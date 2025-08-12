package com.qudopro.ch23;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksConditionsBuffer implements Buffer{
    //Lock to control synchronization with this buffer
    private final Lock accessLock = new ReentrantLock();

    //Conditions to control reading & writing
    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();

    private int buffer = -1;            //Shared by producer & consumer threads
    private boolean occupied = false;   //Whether buffer is occupied

    //Place int value into buffer
    @Override
    public void blockingPut(int value) throws InterruptedException {
        accessLock.lock();              //Lock this object
        try{
            //While buffer is not empty, place thread in waiting state
            while(occupied){
                System.out.println("Producer tries to write");
                displayState("Buffer full. Producer waits");
                canWrite.await();
            }

            buffer = value;             //Set new buffer value

            //Indicate producer can't store another value
            occupied = true;
            displayState("Producer writes " + buffer);
            //Signal any threads waiting to read from buffer
            canRead.signalAll();
        }finally {
            accessLock.unlock();                    //Unlock this object
        }
    }

    //Return value from buffer
    @Override
    public int blockingGet() throws InterruptedException {
        int readValue = 0;          //Initialize value read from buffer
        accessLock.lock();

        try{
            //If there's no data to read
            while(!occupied){
                System.out.println("Consumer tries to read");
                displayState("Buffer empty. Consumer waits");
                canRead.await();
            }

            //Indicate that producer can store another value
            occupied = false;
            readValue = buffer;             //Retrieve value from buffer
            displayState("Consumer reads " + readValue);
            //Signal any threads waiting for buffer to be empty
            canWrite.signalAll();
        }finally {
            accessLock.unlock();                //Unlock this objet
        }

        return readValue;
    }

    //Display current operation & buffer state
    private void displayState(String operation){
        try{
            accessLock.lock();
            System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
        }finally {
            accessLock.unlock();                //Unlock this object
        }
    }
}

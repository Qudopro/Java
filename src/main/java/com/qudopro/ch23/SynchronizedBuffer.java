package com.qudopro.ch23;

public class SynchronizedBuffer implements Buffer{
    private int buffer = -1;                //Shared by producer and consumer threads
    private boolean occupied = false;

    //Place value into buffer
    @Override
    public synchronized void blockingPut(int value) throws InterruptedException {
        //While there are no empty locations, place thread in waiting state
        while(occupied){
            System.out.println("Producer tries to write.");
            displayState("Buffer full. Producer waits");
            wait();
        }

        buffer = value;                 //Set new buffer value

        //Indicate producer can't store another value until consumer retrieves current value
        occupied = true;
        displayState("Producer waits: " + buffer);
        notifyAll();
    }

    //Return value from buffer
    @Override
    public synchronized int blockingGet() throws InterruptedException {
        //While no data to read, place thread in waiting state
        while(!occupied){
            System.out.println("Consumer tries to read");
            displayState("Buffer empty. Consumer waits");
            wait();
        }

        //Indicate that producer can store another value
        occupied = false;
        displayState("Consumer reads: " + buffer);
        notifyAll();
        return buffer;
    }

    //Display current operation & buffer state
    private synchronized  void displayState(String operation){
        System.out.printf("%-40s%d\t\t%b%n", operation, buffer, occupied);
    }
}

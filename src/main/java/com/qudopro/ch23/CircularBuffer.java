package com.qudopro.ch23;

import jdk.jshell.execution.JdiDefaultExecutionControl;

public class CircularBuffer implements Buffer{
    private final int[] buffer = {1, -1,-1};                //Shared buffer
    private int occupiedCells = 0;                          //Count number of buffer used
    private int writeIndex = 0;                             //Index of next element to write to
    private int readIndex = 0;                              //Index of next element to read

    //Place value into buffer
    @Override
    public synchronized void blockingPut(int value) throws InterruptedException {
        //Wait until buffer has space avalaible, then write value
        while (occupiedCells == buffer.length){
            System.out.println("Buffer is full. Producer waits");
            wait();
        }

        buffer[writeIndex] = value;                         //Set a new buffer value
        //Update circular write index
        writeIndex = (writeIndex+1)%buffer.length;

        ++occupiedCells;                    //One more buffer cell is full
        displayState("Producer writes: " + value);
        notifyAll();
    }

    //Return value from buffer
    @Override
    public synchronized int blockingGet() throws InterruptedException {
        //Wait until buffer has data, then read value
        while(occupiedCells == 0){
            System.out.println("Buffer is empty. Consumer waits");
            wait();
        }

        int readValue = buffer[readIndex];          //Read value from buffer
        //Update circular read index
        readIndex = (readIndex + 1) % buffer.length;
        --occupiedCells;                    //One fewer buffer cells are occupied
        displayState("Consumer reads: " + readValue);
        notifyAll();
        return readValue;
    }

    //Display current operation
    public synchronized void displayState(String operation){
        //Output operation & number of occupied buffer cells
        System.out.printf("%s%s%d)%n%s", operation, "(buffer cells occupied: ", occupiedCells, "buffer cells: ");

        for(int value : buffer)
            System.out.printf("%2d", value);

        System.out.printf("%n\t\t\t");
        for(int i = 0; i < buffer.length; i++)
            System.out.print("---- ");
        System.out.printf("%n\t\t\t");

        for(int i = 0; i < buffer.length; i++){
            if(i == writeIndex && i == readIndex)
                System.out.print("  WR  ");              //Write and read index
            else if(i == writeIndex)
                System.out.print(" W ");
            else if(i == readIndex)
                System.out.print(" R ");
            else
                System.out.print("\t");
        }

        System.out.println("\n\n");
    }
}

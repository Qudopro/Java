package com.qudopro.ch23;

import java.security.SecureRandom;
import java.util.Arrays;

public class SynchronizedMutableDataSharing {
    private static final SecureRandom secureRandom = new SecureRandom();
    private final int[] array;              //The shared integer array
    private int writeIndex = 0;             //Shared index of next element to write

    public SynchronizedMutableDataSharing(int size){
        array = new int[size];
    }

    //Add a value to the shared array
    public synchronized void add(int value){
        int position = writeIndex;              //Store the write Index
        //You shouldn't sleep while holding a lock

        //Put value in the appropiate element
        array[position] = value;

        System.out.printf("%s wrote %2d to element %d%n",
                Thread.currentThread().getName(), value, position);

        ++writeIndex;           //Increment index of element to be written
        System.out.printf("Next write index: %d%n", writeIndex);
    }

    //Used for outputting the contents of the shared integer array
    public synchronized String toString(){
        return Arrays.toString(array);
    }
}

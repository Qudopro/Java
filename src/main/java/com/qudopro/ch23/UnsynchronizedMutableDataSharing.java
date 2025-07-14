package com.qudopro.ch23;

import java.security.SecureRandom;
import java.util.Arrays;

public class UnsynchronizedMutableDataSharing {
    private static final SecureRandom secureRandom = new SecureRandom();
    private final int[] array;              //The shared integer array
    private int writeIndex = 0;             //Shared index of next element to write

    public UnsynchronizedMutableDataSharing(int size){
        array = new int[size];
    }

    //Add a value to the shared array
    public void add(int value){
        int position = writeIndex;              //Store the write Index

        try{
            //Put thread to sleep in milliseconds. Muestra los problemas en el acceso no sincronizado de datos mutables
            Thread.sleep(secureRandom.nextInt(5000));
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        //Put value in the appropiate element
        array[position] = value;

        System.out.printf("%s wrote %2d to element %d%n",
                Thread.currentThread().getName(), value, position);

        ++writeIndex;           //Increment index of element to be written
        System.out.printf("Next write index: %d%n", writeIndex);
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }

}

package com.qudopro.ch23;

public class UnsynchronizedBuffer implements Buffer{
    private int buffer = -1;            //Shared by Producer & Consumer threads

    //Place a value into buffer
    @Override
    public void blockingPut(int value) throws InterruptedException {
        System.out.printf("\nProducer writes\t%2d", value);
        buffer = value;
    }

    //Return value from Buffer
    @Override
    public int blockingGet() throws InterruptedException {
        System.out.printf("\nConsumer reads\t%2d", buffer);
        return buffer;
    }
}

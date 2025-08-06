package com.qudopro.ch23;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer{
    private final ArrayBlockingQueue<Integer> buffer;       //shared buffer

    public BlockingBuffer(){
        buffer = new ArrayBlockingQueue<Integer>(1);
    }

    //Place a value into buffer
    @Override
    public void blockingPut(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf("\nProducer writes\t%2d\t%s:\t%2d", value, "Buffer cells occupied", buffer.size());
    }

    //Return value from Buffer
    @Override
    public int blockingGet() throws InterruptedException {
        int readValue  = buffer.take();
        System.out.printf("\nConsumer reads\t%2d\t%s:\t%2d", readValue, "Buffer cells occupied", buffer.size());
        return readValue;
    }
}

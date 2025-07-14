package com.qudopro.ch23;

public class ArrayWriterSynchronized implements Runnable{
    private final SynchronizedMutableDataSharing sharedData;
    private final int startValue;

    public ArrayWriterSynchronized(int value, SynchronizedMutableDataSharing array){
        this.startValue = value;
        this.sharedData = array;
    }

    @Override
    public void run() {
        for(int i = startValue; i < startValue + 3; i++){
            sharedData.add(i);
        }
    }
}

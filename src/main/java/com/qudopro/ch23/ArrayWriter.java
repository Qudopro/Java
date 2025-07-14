package com.qudopro.ch23;

public class ArrayWriter implements Runnable{
    private final UnsynchronizedMutableDataSharing sharedData;
    private final int startValue;

    public ArrayWriter(int value, UnsynchronizedMutableDataSharing array){
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

package com.qudopro.ch23;

public interface Buffer {
    //Place int value into Buffer
    public void blockingPut(int value) throws InterruptedException;

    //Return int value from Buffer
    public int blockingGet() throws InterruptedException;
}

package com.qudopro.ch23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingBufferTest {
    public static void main(String[] args) throws InterruptedException{
        //Create new thread pool with 2 threads
        ExecutorService executorService = Executors.newCachedThreadPool();
        Buffer sharedLocation = new BlockingBuffer();

        System.out.println("Action\t\t\t\t\t\t\t\t\t\t\t\t\tValue\tSum of Producer\tSum of Consumer");

        //Execute the Producer & Consumer giving each access to the sharedLocation
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}

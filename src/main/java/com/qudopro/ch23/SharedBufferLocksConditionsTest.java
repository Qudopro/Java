package com.qudopro.ch23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferLocksConditionsTest {
    public static void main(String[] args) throws InterruptedException{
        //Create new thread pool with 2 threads
        ExecutorService executorService = Executors.newCachedThreadPool();
        Buffer sharedLocation = new LocksConditionsBuffer();

        System.out.printf("%-40s%s\t\t%s%n%-40s%s%n%n", "Operation", "Buffer", "Occupied", "----------","------\t\t-------");

        //Execute the Producer & Consumer giving each access to the sharedLocation
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}

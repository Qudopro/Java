package com.qudopro.ch23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UnsynchronizedMutableDataSharingTest {
    public static void main(String[] args) {
        UnsynchronizedMutableDataSharing sharedData = new UnsynchronizedMutableDataSharing(6);

        //Create 2 task to write to the shared object
        ArrayWriter arrayWriter01 = new ArrayWriter(1, sharedData);
        ArrayWriter arrayWriter02 = new ArrayWriter(12, sharedData);

        //Execute the tasks with an ExecutorService
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(arrayWriter01);
        executorService.execute(arrayWriter02);

        executorService.shutdown();

        try{
            //Wait 1 minute for both writers to finish executing
            boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

            if(tasksEnded){
                System.out.printf("%nContents of sharedDataArray: %n");
                System.out.println(sharedData);
            }else
                System.out.println("Timed out while waiting for tasks to finish");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
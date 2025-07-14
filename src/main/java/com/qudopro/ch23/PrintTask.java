package com.qudopro.ch23;

import java.security.SecureRandom;

public class PrintTask implements Runnable{
    private static final SecureRandom secureRandom = new SecureRandom();
    private final int sleepTime;
    private final String taskName;

    public PrintTask(String taskName){
        this.taskName = taskName;
        sleepTime = secureRandom.nextInt(5000);                 //Time in milliseconds
    }

    //Method run contains the code that a thread will execute
    @Override
    public void run() {
        try{                    //Put thread to sleep for sleepTime amount of time
            System.out.printf("%s going to sleep for %d milliseconds%n", taskName, sleepTime);
            Thread.sleep(sleepTime);                            //Put Thread to sleep
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();                 //Re-interrupt the thread
        }

        System.out.printf("%s done sleeping%n", taskName);
    }
}

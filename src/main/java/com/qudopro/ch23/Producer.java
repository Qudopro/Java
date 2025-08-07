package com.qudopro.ch23;

import java.security.SecureRandom;

public class Producer implements Runnable{
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;                //Reference to shared object

    public Producer(Buffer sharedLocation){
        this.sharedLocation = sharedLocation;
    }

    //Store values
    @Override
    public void run() {
        int sum = 0;

        for(int i = 0; i <= 10; i++){
            try{
                //Sleep 0 to 3 seconds, then place value in Buffer
                //Thread.sleep(generator.nextInt(3000));
                sharedLocation.blockingPut(i);              //Set value in buffer
                //sum += 1;
                //System.out.printf("\t\t\t%2d", sum);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nProducer done producing");
    }
}

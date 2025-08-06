package com.qudopro.ch23;

import java.security.SecureRandom;

public class Consumer implements Runnable{
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;                //Reference to shared location

    public Consumer(Buffer sharedLocation){
        this.sharedLocation = sharedLocation;
    }

    //Read value of sharedLocation
    @Override
    public void run() {
        int sum = 0;
        for(int i = 0; i <= 10; i++){
            try{
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.blockingGet();
                System.out.printf("\t\t\t\t\t\t%2d", sum);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf("%n%s\t%d%n%s%n", "Consumer read values totaling", sum, "Terminating Consumer.");
    }
}

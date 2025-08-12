package com.qudopro.ch23;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class TimeData{
    public Instant start, end;

    //Return total time in seconds
    public double timeInSeconds(){
        return Duration.between(start, end).toMillis()/1000.0;
    }
}

public class FibonacciCallableFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Performs synchronous fibonacci(45) y fibonacci(44) calculations
        System.out.println("Synchronous long running calculations");
        TimeData synchronousResult1 = startFibonacci(45);
        TimeData synchronousResult2 = startFibonacci(44);

        double synchronousTime = calculateTime(synchronousResult1, synchronousResult2);

        System.out.printf("Total calculation time = %.3f seconds%n", synchronousTime);

        //Performs asynchronous fibonacci(45) & fibonacci(44) calculation
        System.out.println("\nAsynchronous long running calculations");
        CompletableFuture<TimeData> futureResult1 =
                CompletableFuture.supplyAsync(()->startFibonacci(45));
        CompletableFuture<TimeData> futureResult2 =
                CompletableFuture.supplyAsync(()->startFibonacci(44));

        //Wait for results from the asynchronous operations
        TimeData asynchronousResult1 = futureResult1.get();
        TimeData asynchronousResult2 = futureResult2.get();

        double asynchrnousTime = calculateTime(asynchronousResult1, asynchronousResult2);

        System.out.printf("Total calculation time = %.3f seconds%n", asynchrnousTime);

        //Display time difference as a percentage
        String percentage = NumberFormat.getPercentInstance().format(synchronousTime/asynchrnousTime);
        System.out.printf("%nSynchronous calculations took %s more time than" +
                " the asynchronous calculations%n", percentage);
    }

    private static TimeData startFibonacci(int n){
        //Create a TimeData object to store times
        TimeData timeData = new TimeData();

        System.out.printf("Calculating fibonacci (%d)%n",n);
        timeData.start = Instant.now();
        long fibonacciValue = fibonacci(n);
        timeData.end = Instant.now();

        displayResult(n, fibonacciValue, timeData);
        return timeData;
    }

    //Recursive method fibonacci
    private static long fibonacci(long n){
        if(n == 0 || n == 1)
            return n;
        else
            return fibonacci(n-1)+fibonacci(n-2);
    }

    //Display results
    private static void displayResult(int n, long value, TimeData timeData){
        System.out.printf("fibonacci(%d) = %d%n", n, value);
        System.out.printf("Calculation time for fibonacci (%d) = %.3f seconds%n",
                n, timeData.timeInSeconds());
    }

    //Display fibonacci calculation result & total calculation time
    private static double calculateTime(TimeData result1, TimeData result2){
        TimeData bothThreads = new TimeData();

        //Determine earlier start time
        bothThreads.start=result1.start.compareTo(result2.start) < 0 ? result1.start : result2.start;

        //Determine earlier end time
        bothThreads.end= result1.end.compareTo(result2.end) > 0 ? result1.end : result2.end;

        return bothThreads.timeInSeconds();
    }
}

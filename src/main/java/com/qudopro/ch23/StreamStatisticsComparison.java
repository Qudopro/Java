package com.qudopro.ch23;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.stream.LongStream;

public class StreamStatisticsComparison {
    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();
        //Create array of random long values
        long[] values = secureRandom.longs(10_000_000,1, 1001).toArray();

        //Perform calculations separately
        Instant separateStart = Instant.now();
        long count = Arrays.stream(values).count();
        long sum = Arrays.stream(values).sum();
        long min = Arrays.stream(values).min().getAsLong();
        long max = Arrays.stream(values).max().getAsLong();
        double average = Arrays.stream(values).average().getAsDouble();
        Instant separateEnd = Instant.now();

        //Display results
        System.out.println("Calculations performed separately");
        System.out.printf("%n\tcount:%,d%n\tsum:%,d%n\tmin:%,d%n\tmax:%,d%n\taverage:%f%n",
                count, sum,min,max,average
                );
        System.out.printf("Total time in milliseconds: %d%n%n",
                Duration.between(separateStart,separateEnd).toMillis());

        //Time sum operation with sequential Stream
        LongStream stream1 = Arrays.stream(values);
        System.out.println("Calculating statistics on sequential stream");
        Instant sequentialStart = Instant.now();
        LongSummaryStatistics results1 = stream1.summaryStatistics();
        Instant sequentialEnd = Instant.now();

        //Display results
        displayStatistics(results1);
        System.out.printf("Total time in milliseconds: %d%n%n",
                Duration.between(sequentialStart,sequentialEnd).toMillis());

        //Time sum operation with parallel stream
        LongStream stream2 = Arrays.stream(values).parallel();
        System.out.println("Calculating statistics on parallelStream");
        Instant parallelStart = Instant.now();
        LongSummaryStatistics results2 = stream2.summaryStatistics();
        Instant parallelEnd = Instant.now();

        //Display results
        displayStatistics(results2);
        System.out.printf("Total time in milliseconds: %d%n%n",
                Duration.between(parallelStart,parallelEnd).toMillis());
    }

    //Display's LongSummaryStatistics values
    private static void displayStatistics(LongSummaryStatistics stats){
        System.out.println("Statistics");
        System.out.printf("\tcount: %,d%n", stats.getCount());
        System.out.printf("\tsum: %,d%n\tmin: %,d%n\tmax: %,d%naverage: %f%n",
                stats.getSum(), stats.getMin(), stats.getMax(),
                stats.getAverage()
                );
    }
}

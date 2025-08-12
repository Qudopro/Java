package com.qudopro.ch23;

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class SortComparison {
    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();

        int[] arrays1 = secureRandom.ints(500_000_000).toArray();
        int[] arrays2 = new int[arrays1.length];

        System.arraycopy(arrays1,0, arrays2,0,arrays1.length);

        //Time the sorting of array1 with Arrays method sort
        System.out.println("Starting sort with Arrays method sort");
        Instant sortStart = Instant.now();
        Arrays.sort(arrays1);
        Instant sortEnd = Instant.now();

        long sortTime = Duration.between(sortStart,sortEnd).toMillis();
        System.out.printf("Total time in milliseconds: %d%n", sortTime);

        //Time the sorting of array2 with Arrays method parallelSort
        System.out.println("Starting sort with Arrays method parallelSort");
        Instant parallelSortStart = Instant.now();
        Arrays.parallelSort(arrays2);
        Instant parallelSortEnd = Instant.now();

        long parallelSortTime = Duration.between(parallelSortStart, parallelSortEnd).toMillis();
        System.out.printf("Total time in milliseconds: %d%n", parallelSortTime);

        String percentage = NumberFormat.getPercentInstance().format((double)sortTime/parallelSortTime);
        System.out.printf("%nSort took %s more than parallelSort%n", percentage);
    }
}

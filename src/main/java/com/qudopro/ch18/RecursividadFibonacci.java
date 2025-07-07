package com.qudopro.ch18;

import java.math.BigInteger;

public class RecursividadFibonacci {
    public static BigInteger fibonacci(BigInteger numero){
        if(numero.equals(BigInteger.ZERO) || numero.equals(BigInteger.ONE))             //DOS CASOS BASES
            return numero;
        else
            return fibonacci(numero.subtract(BigInteger.ONE)).add(fibonacci(numero.subtract(BigInteger.TWO)));
    }
    public static void main(String[] args){
        long initTime = System.currentTimeMillis();
        for(int i = 0; i <= 40; i++){
            System.out.printf("Fiboacci %d = %,d%n", i, fibonacci(BigInteger.valueOf(i)));
        }

        long finalTime = System.currentTimeMillis();

        System.out.println("Time: " + (finalTime-initTime));
    }
}

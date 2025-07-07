package com.qudopro.ch18;

import java.math.BigInteger;

public class RecursividadFactorial2 {
    public static BigInteger factorial(BigInteger numero){
        if(numero.compareTo(BigInteger.ONE) <= 0)                       //Caso Base
            return BigInteger.ONE;
        else
            return numero.multiply(factorial(numero.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args){
        for(int i = 0; i <= 50; i++){
            System.out.printf("%d! = %d%n", i, factorial(BigInteger.valueOf(i)));
        }
    }
}

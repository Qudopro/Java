package com.qudopro.ch18;

public class RecursividadFactorial {
    public static long factorial(long numero){
        if(numero <= 1)
            return 1;                                                       //Caso base
        else
            return numero*factorial(numero-1);                      //Recursividad
    }

    public static void main(String[] args){
        for(int i = 0; i <= 21; i++){
            System.out.printf("%d! = %d%n", i, factorial(i));
        }
    }
}

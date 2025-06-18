package com.qudopro.ch05;

public class SumaFor {
    public static void main(String[] args){
        int total = 0;

        for(int i = 2; i <= 20; i+=2){
            total += i;
        }

        System.out.printf("Se han sumado los numeros pares del 2 al 20 y el resultado es:\s%d%n", total);
    }
}

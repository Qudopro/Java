package com.qudopro.ch07;

import java.security.SecureRandom;

public class AccesoArreglo3Sintesis {
    public static void main(String[] args){
        SecureRandom secure = new SecureRandom();
        int[] frecuencia = new int[7];

        for(int i = 0; i < 6_000_000; i++){
            ++frecuencia[1+secure.nextInt(6)];
        }

        System.out.printf("%s%10s%n", "Cara", "Frecuencia");
        for(int i = 1; i < frecuencia.length; i++)
            System.out.printf("%4d%10d%n", i, frecuencia[i]);
    }
}

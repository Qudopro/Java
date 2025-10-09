package com.qudopro.ch06;

public class Exponenciacion {
    public static void main(String[] args){
        System.out.println(enteroPotencia(2,4));
    }

    public static double enteroPotencia(int base, int exponente){
        double entero = 1.0;

        if(exponente > 0){
            for(int i = 1; i <= exponente; i++)
                entero = entero*base;
        }

        return entero;
    }
}

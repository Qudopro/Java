package com.qudopro.ch06;

public class SobrecargaMetodos {
    public static void main(String[] args){
        System.out.printf("El cuadrado de 7 es:\s%d%n", cuadrado(7));
        System.out.printf("El cuadrado de 7.5 es:\s%,.2f%n", cuadrado(7.5));
    }


    private static int cuadrado(int x){
        return x*x;
    }

    private static double cuadrado(double x){
        return x*x;
    }
}

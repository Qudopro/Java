package com.qudopro.ch07;

public class LongitudVariable {
    public static double promedio(double... datos){
        double total = 0.0;

        for(double i : datos)
            total += i;

        return total/datos.length;
    }

    public static void main(String[] args){
        double d1 = 10, d2 = 32, d3 = 43, d4 = 2;

        System.out.printf("El promedio para los datos ingresados %f, %f, %f, %f fue de:\t%.2f%n", d1, d2, d3, d4, promedio(d1, d2, d3, d4));
        System.out.printf("El promedio para los datos ingresados %f, %f, %f fue de:\t%.2f%n", d1, d2, d3, promedio(d1, d2, d3));
        System.out.printf("El promedio para los datos ingresados %f, %f fue de:\t%.2f%n", d1, d2, promedio(d1, d2));
        System.out.printf("El promedio para los datos ingresados %f fue de:\t%.2f%n", d1, promedio(d1));
    }
}

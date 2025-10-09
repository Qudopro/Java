package com.qudopro.ch06;

import java.util.Scanner;

public class RedondeoNumeros2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba un numero decimal:\t");
        double dato = entrada.nextDouble();

        System.out.println("El numero ingresado es: " + dato);

        System.out.println("El numero redondeado al entero mas cercano es: " + redondearAInteger(dato));
        System.out.println("El numero redondeado al decimal mas cercano es: " + redondearADecimas(dato));
        System.out.println("El numero redondeado al centimo mas cercano es: " + redondearACentecimas(dato));
        System.out.println("El numero redondeado al milesimo mas cercano es: " + redondearAMilecimas(dato));
    }

    public static double redondearAInteger(double dato){
        return Math.floor(dato);
    }

    public static double redondearADecimas(double dato){
        return Math.floor(dato*10+0.5)/10;
    }

    public static double redondearACentecimas(double dato){
        return Math.floor(dato*100+0.5)/100;
    }

    public static double redondearAMilecimas(double dato){
        return Math.floor(dato*1000+0.5)/1000;
    }
}
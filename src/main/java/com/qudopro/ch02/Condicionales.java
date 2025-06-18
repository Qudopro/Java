package com.qudopro.ch02;

import java.util.Scanner;

public class Condicionales {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        int numero1, numero2;

        System.out.println("Ingrese el primer entero:\t");
        numero1 = entrada.nextInt();

        System.out.println("Ingrese el segundo entero:\t");
        numero2 = entrada.nextInt();

        if(numero1 == numero2)
            System.out.println("Ambos numeros ingresados son iguales");

        if(numero1 != numero2)
            System.out.println("Ambos numeros son distintos");

        if(numero1 > numero2)
            System.out.println("El primer numero ingresado es mayor que el segundo");

        if(numero1 < numero2)
            System.out.println("El segundo numero ingresado es mayor que el primero");
    }
}

package com.qudopro.ch02;

import java.util.Scanner;

public class IngresarDatos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        int numero1, numero2, numero3;

        System.out.println("Ingrese el primer numero:\t");
        numero1 = entrada.nextInt();

        System.out.println("Ingrese el segundo numero:\t");
        numero2 = entrada.nextInt();

        numero3 = numero1+numero2;

        System.out.printf("%s\s%d\s%s\s%d\s%s\s%d", "La suma de", numero1, "+", numero2, "es:", numero3);
    }
}

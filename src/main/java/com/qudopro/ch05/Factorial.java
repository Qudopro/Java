package com.qudopro.ch05;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        long factorial = 1L;

        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduzca el numero al cual vamos a buscar el factorial:\t\t");
        int numero = entrada.nextInt();

        for(int i = 1; i <= numero; i++){
            factorial = factorial * i;
            System.out.printf("%,d!: %,d%n", i, factorial);
        }

        System.out.printf("El factorial es: %,d%n", factorial);
    }
}

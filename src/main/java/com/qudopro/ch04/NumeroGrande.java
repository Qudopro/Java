package com.qudopro.ch04;

import java.util.Scanner;

public class NumeroGrande {
    public static void main(String[] args){
        int contador = 1;
        Scanner entrada = new Scanner(System.in);

        int maximo = 0;
        while(contador <= 10){
            System.out.println("Ingrese un valor entero positivo:");
            int dato = entrada.nextInt();

            if(dato > 0) {
                if (maximo < dato){
                    maximo = dato;
                }
            }

            contador++;
        }

        System.out.println("El valor maximo ingresado es: " + maximo);
    }
}

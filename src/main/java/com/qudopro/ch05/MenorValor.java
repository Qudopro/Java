package com.qudopro.ch05;

import java.util.Scanner;

public class MenorValor {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int contador = 0;
        int iteraciones = 0;
        int valor = 0;
        int minimo = 0;

        System.out.println("Se determinara el valor minimo introducido por el usuario:\n\n");
        do{
            System.out.print("Escriba un valor. El valor introducido sera el numero de valores a ingresar:\t\t");
            valor = entrada.nextInt();
            if(contador == 0) {
                iteraciones = valor;
                minimo = valor;
            }

            if(minimo > valor)
                minimo = valor;

            contador++;
        }while (contador < iteraciones);


        System.out.println("El menor valor introducido fue: " + minimo);
    }
}

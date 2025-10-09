package com.qudopro.ch06;

import java.util.Scanner;

public class RedondeoNumeros {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba un numero de punto flotante:\t");
        double numero = entrada.nextDouble();

        System.out.printf("Se redondea el numero %.2f al entero mas cercano %.2f", numero, Math.floor(numero+0.5));
    }
}

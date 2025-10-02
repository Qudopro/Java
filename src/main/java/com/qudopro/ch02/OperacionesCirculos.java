package com.qudopro.ch02;

import java.util.Scanner;

public class OperacionesCirculos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el valor del radio del circulo:\t");
        int radio = entrada.nextInt();

        System.out.printf("El diametro del circulo es: %d%nLa circunferencia del circulo es: %.2f%nEl area del circulo es: %.2f%n",
            2*radio, 2*Math.PI*radio, Math.PI*Math.pow(radio,2)
        );
    }

}

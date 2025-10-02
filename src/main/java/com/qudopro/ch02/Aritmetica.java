package com.qudopro.ch02;

import java.util.Scanner;

public class Aritmetica {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba el primer numero:\t");
        int numero1 = entrada.nextInt();

        System.out.print("Escriba el segundo numero:\t");
        int numero2 = entrada.nextInt();

        int suma = numero1 + numero2;
        int producto = numero1 * numero2;
        int diferencia = numero1 - numero2;
        int cociente = numero1 / numero2;

        System.out.printf("Operaciones con los numeros introducidos: %d y %d:%n%s\t%d%n%s\t%d%n%s\t%d%n%s\t%d%n",
                numero1, numero2, "Suma:", suma, "Diferencia:", diferencia, "Producto:", producto, "Cociente:", cociente);
    }
}

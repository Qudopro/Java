package com.qudopro.ch02;

import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escriba un digito:");
        int numero1 = entrada.nextInt();
        System.out.println("Escriba otro digito:");
        int numero2 = entrada.nextInt();

        if(numero1%numero2 == 0)
            System.out.println("Los numeros introducidos son multiplos");
        else
            System.out.println("Los numeros no son multiplos");
    }
}

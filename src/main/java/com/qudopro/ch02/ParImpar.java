package com.qudopro.ch02;
import java.util.Scanner;
public class ParImpar {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escriba un digito:");
        int numero = entrada.nextInt();

        if(numero % 2 == 0)
            System.out.println("El numero introducido es par");
        else
            System.out.println("El numero introducido es impar");
    }
}

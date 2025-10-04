package com.qudopro.ch04;

import java.util.Scanner;

public class Palindromos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese un valor de 5 digitos o -1 para salir: ");
        int numero = entrada.nextInt();

        while(numero != -1){
            if(numero/10000 < 10 && numero/10000 != 0){
                int cifra5 = numero/10000;
                int cifra4 = numero%10000/1000;
                int cifra2 = numero%100/10;
                int cifra1 = numero%10;

                if(cifra5 == cifra1 && cifra4 == cifra2)
                    System.out.println("El numero es palindromo");
                else
                    System.out.println("El numero ingresado no es palindromo");
            }else{
                System.out.println("Numero no valido");
            }
            System.out.print("Ingrese un valor de 5 digitos o -1 para salir: ");
            numero = entrada.nextInt();
        }
    }
}

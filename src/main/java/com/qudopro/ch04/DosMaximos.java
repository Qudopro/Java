package com.qudopro.ch04;

import java.util.Scanner;

public class DosMaximos {
    public static void main(String[] args){
        int contador = 1;
        Scanner entrada = new Scanner(System.in);

        int maximo = 0;
        int maximo2 = 0;
        int maximo3 = 0;
        while(contador <= 3){
            System.out.print("Ingrese un entero:\t");
            int dato = entrada.nextInt();

            if (maximo < dato){
                maximo = dato;
            }

            if(contador == 1){
                maximo3 = maximo;
            }else{
                if(maximo3 < maximo){
                    maximo2 = maximo3;
                }

                maximo3 = dato;
            }

            contador++;
        }

        System.out.println("El valor maximo ingresado es: " + maximo);
        System.out.println("El segundo valor maximo introducido fue: " + maximo2);
    }
}

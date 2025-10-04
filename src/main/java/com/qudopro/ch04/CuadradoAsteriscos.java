package com.qudopro.ch04;

import java.util.Scanner;

public class CuadradoAsteriscos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la longitud del cuadrado entre 1 a 20");
        int longitud = entrada.nextInt();

        if(longitud >= 1 && longitud <= 20){
            for(int i = 1; i <= longitud; i++){
                if(i == 1 || i== longitud)
                    System.out.print("*".repeat(longitud));
                else{
                    System.out.print("*" + " ".repeat(longitud-2) + "*");
                }
                System.out.println();
            }
        }
    }
}

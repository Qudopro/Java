package com.qudopro.ch02;

import java.util.Scanner;

public class SeparacionEnteros {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduzca un entero de 5 cifras:\t");
        int numero = entrada.nextInt();

        int digito1 = 0, digito2 = 0, digito3 = 0, digito4 = 0, digito5 = 0;

        if(numero/10000 > 0 & numero/10000<10 ){
            digito1 = numero/10000;
            digito2 = numero/1000%10;
            digito3 = numero/100%10;
            digito4 = numero/10%10;
            digito5 = numero%10;
            System.out.printf("%3d%3d%3d%3d%3d", digito1, digito2, digito3, digito4, digito5);
        }else{
            System.out.println("El numero no tiene 5 cifras");
        }
    }
}

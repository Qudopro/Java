package com.qudopro.ch02;
import java.util.Scanner;
public class ComparacionEnteros {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba el primer numero:\t");
        int numero1 = entrada.nextInt();

        System.out.print("Escriba el segundo numero:\t");
        int numero2 = entrada.nextInt();

        if(numero1 > numero2)
            System.out.println(numero1 + " es mas grande");
        else if(numero1 < numero2)
            System.out.println(numero2 + " es mas grande");
        else
            System.out.println("Estos numeros son iguales");
    }
}

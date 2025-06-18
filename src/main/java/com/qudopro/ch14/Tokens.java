package com.qudopro.ch14;

import java.util.Scanner;

public class Tokens{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba un enunciado: ");
        String enunciado = entrada.nextLine();

        String[] tokens = enunciado.split(" ");
        System.out.println("Numero de elementos: " + tokens.length);

        System.out.println("Elementos en la cadena");
        for(String s : tokens){
            System.out.println(s);
        }
    }
}

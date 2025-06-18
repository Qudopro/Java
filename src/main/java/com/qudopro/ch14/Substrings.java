package com.qudopro.ch14;

public class Substrings {
    public static void main(String[] args){
        String vocales = "aeiou";

        System.out.printf("La subcadena desde el indice 2 hasta el final es: \"%s\"%n", vocales.substring(2));
        System.out.printf("La subcadena desde el indice 2 hasta pero sin incluir el 4 indice es: \"%s\"%n", vocales.substring(2, 4));
    }
}

package com.qudopro.ch14;

import java.util.Scanner;

public class CharacterClass {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        //Obtén el caracter ingresado por el usuario
        System.out.println("Escriba un caracter e imprima enter");
        String cadena = entrada.next();
        char c = cadena.charAt(0);

        System.out.println("Character is defined: " + Character.isDefined(c));
        System.out.println("Character is digit: " + Character.isDigit(c));
        System.out.println("Character is java identifier: " + Character.isJavaIdentifierPart(c));
        System.out.println("Character is java start identifier: " + Character.isJavaIdentifierStart(c));
        System.out.println("Character is letter or digit: " + Character.isLetterOrDigit(c));
        System.out.println("Character is letter: " + Character.isLetter(c));
        System.out.println("Character is lowerCase: " + Character.isLowerCase(c));
        System.out.println("Character is upperCase: " + Character.isUpperCase(c));
        System.out.println("Character to lowerCase: " + Character.toLowerCase(c));
        System.out.println("Character to upperCase: " + Character.toUpperCase(c));
    }
}

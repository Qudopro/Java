package com.qudopro.ch14;

import java.util.Scanner;

public class CharacterClass2 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        //Obtén el caracter ingresado por el usuario
        System.out.println("Escriba la base de un numero");
        int base = entrada.nextInt();

        System.out.printf("Seleccione una opcion: %n1-- %s%n2-- %s%n",
                "Convertir Digito a Caracter", "Convertir Caracter a Digito");
        int opcion = entrada.nextInt();

        switch(opcion){
            case 1:             //Convertir digito a caracter
                System.out.println("Escriba un digito: ");
                int digito = entrada.nextInt();
                System.out.println(Character.forDigit(digito,base));
                break;
            case 2:             //Convertir caracter a digito
                System.out.println("Escriba un caracter: ");
                char caracter = entrada.next().charAt(0);
                System.out.println(Character.digit(caracter, base));
                break;
        }
    }
}

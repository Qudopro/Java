package com.qudopro.ch14;

public class UtileriasString {
    public static void main(String[] args){
        String cadena1 = "Hola";
        String cadena2 = "ADIOS";
        String cadena3 = "    espacios    ";

        System.out.print(cadena1 + "\n" + cadena2 + "\n" + cadena3 + "\n");

        //REPLACE
        System.out.println(cadena1.replace('H', 'h'));

        //MAYUSCULAS & MINUSCULAS
        System.out.println(cadena1.toUpperCase());
        System.out.println(cadena2.toLowerCase());

        //TRIM
        System.out.println(cadena3.trim());

        //TO CHAR ARRAY
        char[] arreglo = cadena1.toCharArray();
        System.out.print("cadena1: ");

        for(char c : arreglo)
            System.out.print(c + " ");

        System.out.println();
    }
}

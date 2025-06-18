package com.qudopro.ch14;

public class Comparador {
    public static void main(String[] args){
        String cadena1 = new String("Hola");
        String cadena2 = "adios";
        String cadena3 = "Felicidades";
        String cadena4 = "felicidades";

        System.out.println("cadena1:\t " + cadena1);
        System.out.println("cadena2:\t " + cadena2);
        System.out.println("cadena3:\t " + cadena3);
        System.out.println("cadena4:\t " + cadena4);

        //Prueba de igualdad
        if(cadena1.equals("Hola"))
            System.out.println("cadena1 es igual a \"Hola\"");

        if(cadena3.equalsIgnoreCase(cadena4))
            System.out.println("cadena3 y cadena4 son iguales");

        //COMPARACIONES
        System.out.println("cadena1.compareTo(cadena2): " + cadena1.compareTo(cadena2));
        System.out.println("cadena1.compareTo(cadena1): " + cadena1.compareTo(cadena1));
        System.out.println("cadena3.compareTo(cadena4): " + cadena3.compareTo(cadena4));
        System.out.println("cadena4.compareTo(cadena3): " + cadena4.compareTo(cadena3));

        //RegionMatches
        if(cadena3.regionMatches(0, cadena4, 0, 5))
            System.out.println("Los primeros 5 caracteres de cadena3 y cadena4 son iguales CaseSensitive");

        if(cadena3.regionMatches(true, 0, cadena4, 0, 5))
            System.out.println("Los primeros 5 caracteres de cadena3 y cadena4 son iguales No CaseSensitive");
    }
}

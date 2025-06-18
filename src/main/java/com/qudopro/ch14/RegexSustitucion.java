package com.qudopro.ch14;

import java.util.Arrays;

public class RegexSustitucion {
    public static void main(String[] args){
        String cadena1 = "Termina con 5 estrellas: *****";
        String cadena2 = "1,2,3,4,5,6,7,8,9";
        String cadena3 = cadena1;

        System.out.println("Cadena 1: " + cadena1);
        System.out.println("Cadena 2: " + cadena2);

        //SUSTITUCIONES
        cadena1 = cadena1.replaceAll("\\*", "^");
        System.out.println("Cadena 1: " + cadena1);
        cadena1 = cadena1.replaceAll("estrellas", "potenciadores");
        System.out.println("Cadena 1: " + cadena1);

        cadena3 = cadena3.replaceAll("\\w", "palabra");

        //Sustituye los primeros 3 digitos con 'digitos'
        for(int i = 0; i < 3; i++)
            cadena2 = cadena2.replaceFirst("\\d", "Digito");
        System.out.println("Cadena 2: " + cadena2);

        //Division de cadenas
        System.out.print("Cadena divididas por comas: ");
        String[] resultados = cadena2.split(",\\s*");

        System.out.println(Arrays.toString(resultados));
    }
}

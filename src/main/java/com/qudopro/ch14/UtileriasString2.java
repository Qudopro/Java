package com.qudopro.ch14;

public class UtileriasString2 {
    public static void main(String[] args){
        String cadena1 = "Hola a todos";
        char[] arregloChar = new char[5];

        System.out.println("La longitud de la cadena es: \t" + cadena1.length());

        //Inversion de la cadena
        System.out.println("Se invertira la cadena: " + cadena1);
        for(int i = cadena1.length() - 1; i >= 0; i--)
            System.out.print(cadena1.charAt(i));
        System.out.println();

        //Copiar los caracteres de las cadenas en un arreglo
        cadena1.getChars(0, 5, arregloChar, 0);
        System.out.println("Contenido del arreglo de caracteres");
        for(char c : arregloChar)
            System.out.print(c);

        System.out.println();
    }
}

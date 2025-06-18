package com.qudopro.ch14;

public class StringConstructores {
    public static void main(String[] args){
        char[] arregloChar = {'t', 'e','a','m','o'};

        String cadena1 = new String("Hola");
        String cadena2 = new String();
        String cadena3 = new String(cadena1);
        String cadena4 = new String(arregloChar);
        String cadena5 = new String(arregloChar, 1, 3);

        System.out.println("Cadena 1:\t" + cadena1);
        System.out.println("Cadena 2:\t" + cadena2);
        System.out.println("Cadena 3:\t" + cadena3);
        System.out.println("Cadena 4:\t" + cadena4);
        System.out.println("Cadena 5:\t" + cadena5);
    }

}

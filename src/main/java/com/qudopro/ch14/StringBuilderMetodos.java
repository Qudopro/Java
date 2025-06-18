package com.qudopro.ch14;

public class StringBuilderMetodos {
    public static void main(String[] args){
        StringBuilder builder1 = new StringBuilder("Hola mundo!");

        System.out.println(builder1);
        //MODIFICACION DE CARACTERES
        System.out.printf("Caracter en la posicion 0: %s%nCaracter en la posicion 3 es: %s%n",
                    builder1.charAt(0), builder1.charAt(3)
                );
        builder1.setCharAt(0, 'h');

        System.out.println(builder1);

        //ARREGLOS
        char[] charArray = new char[builder1.length()];
        builder1.getChars(0, builder1.length(), charArray, 0);

        System.out.println("El arreglo tiene: ");
        for(char c : charArray)
            System.out.print(c);
        System.out.println();
        //INVERSION
        builder1.reverse();
        System.out.println(builder1);

    }

}

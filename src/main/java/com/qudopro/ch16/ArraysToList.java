package com.qudopro.ch16;

import java.util.Arrays;
import java.util.LinkedList;
public class ArraysToList {
    public static void main(String[] args){
        //Convertir arreglo en lista
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan"};
        LinkedList<String> list1 = new LinkedList<>(Arrays.asList(colores));

        list1.addLast("Amarillo");
        list1.add(3,"Cafe");
        list1.addFirst("Violeta");

        //Convertir lista en arreglo
        colores = list1.toArray(new String[list1.size()]);

        System.out.println("Colores: ");
        for(String color : colores)
            System.out.printf("%s ", color);

        System.out.println();
    }
}

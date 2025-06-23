package com.qudopro.ch16;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
    public static void main(String[] args){
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan"};

        SortedSet<String> sortedSet = new TreeSet<>(Arrays.asList(colores));
        System.out.println("Se imprimira el conjunto ordenado: ");
        imprimirConjunto(sortedSet);

        //HeadSet
        System.out.println("headSet (\"Blanco\")");
        imprimirConjunto(sortedSet.headSet("Blanco"));

        //TailSet
        System.out.println("tailSet (\"Blanco\")");
        imprimirConjunto(sortedSet.tailSet("Blanco"));

        //Obtiene el primer y ultimo elemento
        System.out.println("Primer elemento del sortedSet: " + sortedSet.first());
        System.out.println("Ultimo elemento del sortedSet: " + sortedSet.last());
    }

    //Imrpimir elementos
    private static void imprimirConjunto(SortedSet<String> sortedSet){
        for(String s : sortedSet)
            System.out.printf("%s ", s);

        System.out.println();
    }
}

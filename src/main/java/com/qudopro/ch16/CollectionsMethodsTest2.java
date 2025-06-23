package com.qudopro.ch16;

import java.util.*;

public class CollectionsMethodsTest2 {
    public static void main(String[] args){
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan"};
        List<String> lista = Arrays.asList(colores);
        List<String> lista2 = new ArrayList<>();

        lista2.add("Negro");
        lista2.add("Amarillo");
        lista2.add("Verde");

        System.out.println("Lista 2");
        for(String s : lista2)
            System.out.printf("%s ", s);
        System.out.println();

        Collections.addAll(lista2, colores);

        System.out.println("Lista 2");
        for(String s : lista2)
            System.out.printf("%s ", s);
        System.out.println();

        int frecuencia = Collections.frequency(lista2, "Rojo");
        System.out.println("Veces en las que se encuentra el elemento Rojo en la lista2: " +
                    frecuencia
                );

        boolean union = Collections.disjoint(lista, lista2);
        System.out.printf("La lista list1 y list2 %s elementos en comun",
            union ? "no tienen" : "tienen"
        );

    }
}

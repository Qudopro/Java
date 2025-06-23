package com.qudopro.ch16;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DescendingSort {
    public static void main(String[] args){
        String[] palos = {"Corazones", "Diamantes", "Bastos", "Espadas"};
        List<String> lista = Arrays.asList(palos);
        System.out.println("Elementos del arreglo desordenados: " + lista);

        Collections.sort(lista, Comparator.reverseOrder());
        System.out.println("Elementos del arreglo ordenados pero invertidos: " + lista);
    }
}

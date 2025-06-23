package com.qudopro.ch16;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AscendingSort {
    public static void main(String[] args){
        String[] palos = {"Corazones", "Diamantes", "Bastos", "Espadas"};
        List<String> lista = Arrays.asList(palos);

        System.out.println("Elementos de la lista desordenados: " + lista);

        Collections.sort(lista);
        System.out.println("Elementos de la lista ordenados: " + lista);
    }
}

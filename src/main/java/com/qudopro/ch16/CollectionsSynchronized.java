package com.qudopro.ch16;

import java.util.*;

public class CollectionsSynchronized {
    public static void main(String[] args){
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan"};
        List<String> listColors = new ArrayList<>(Arrays.asList(colores));
        List<String> list = Collections.synchronizedList(listColors);

        System.out.println(list);
    }
}

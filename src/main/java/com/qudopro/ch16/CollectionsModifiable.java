package com.qudopro.ch16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsModifiable {
    public static void main(String[] args){
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan"};
        List<String> listColors = new ArrayList<>(Arrays.asList(colores));
        List<String> list = Collections.unmodifiableList(listColors);
        System.out.println(listColors);

        try{
            list.add("Negro");
            System.out.println(listColors);
        }catch (UnsupportedOperationException e){
            System.err.println("No se puede modificar la lista");
            e.printStackTrace();
        }
    }
}

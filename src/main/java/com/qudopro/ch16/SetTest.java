package com.qudopro.ch16;

import java.util.*;

public class SetTest {
    public static void main(String[] args){
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan", "Rojo"};
        List<String> lista = Arrays.asList(colores);
        System.out.printf("Contenido de la lista: %s%n", lista);

        //Imprimir lista sin elementos duplicados
        imprimirSinDuplicados(lista);
    }

    //Creación de objeto Set para eliminar duplicados
    private static void imprimirSinDuplicados(Collection<String> lista){
        //Crea un objeto Set
        Set<String> set = new HashSet<>(lista);
        System.out.println("Se imprimira la lista sin elementos duplicados");
        for(String s : set)
            System.out.printf("%s ", s);

        System.out.println();
    }

}

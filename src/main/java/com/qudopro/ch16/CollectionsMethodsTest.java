package com.qudopro.ch16;

import java.io.FilterOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsMethodsTest {
    public static void main(String[] args){
        Character[] letras = {'P', 'C', 'M'};
        List<Character> lista = Arrays.asList(letras);
        System.out.println("El objeto lista tiene: ");
        imprimirLista(lista);

        //Invertir contenido
        Collections.reverse(lista);
        System.out.println("El objeto lista tiene: ");
        imprimirLista(lista);

        //Copiar arreglo
        Character[] letrasCopy = new Character[3];
        List<Character> listaCopia = Arrays.asList(letrasCopy);
        Collections.copy(listaCopia, lista);
        System.out.println("Copiando el contenido de las listas");
        imprimirLista(listaCopia);

        //Llena un objeto lista
        Collections.fill(lista, 'R');
        System.out.println("Lista actualizada: ");
        imprimirLista(lista);
    }

    //Imprimir la información del objeto List
    private static void imprimirLista(List<Character> lista){
        for(Character c : lista)
            System.out.printf("%s ", c);

        System.out.printf("\nElemento Maximo: %s\nElemento Minimo: %s\n",
                    Collections.max(lista), Collections.min(lista)
                );
    }
}

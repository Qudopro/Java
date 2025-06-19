package com.qudopro.ch16;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
    public static void main(String[] args){
        //Llenar list
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan"};
        List<String> list1 = new LinkedList<>();

        for(String color : colores)
            list1.add(color);

        String[] colores2 = {"Violeta", "Amarillo", "Naranja"};
        List<String> list2 = new LinkedList<>();

        for(String color : colores2)
            list2.add(color);

        //Operaciones con los objetos List
        list1.addAll(list2);                    //Concatenación de listas
        list2 = null;                           //Limpieza de recursos
        imprimirLista(list1);

        convertirCadenasMayusculas(list1);
        imprimirLista(list1);

        System.out.println("Eliminando los elementos 4 a 6");
        eliminarElementosLista(list1, 4, 7);
        imprimirLista(list1);
        imprimirListaInvertida(list1);
    }

    //Imprime el contenido del objeto List
    private static void imprimirLista(List<String> lista){
        System.out.println("Se imprimiran los elementos de la lista: ");
        for(String s : lista)
            System.out.printf("%s ", s);

        System.out.println();
    }

    //Convierte en mayusculas los objetos de la lista
    private static void convertirCadenasMayusculas(List<String> lista){
        ListIterator<String> iterador = lista.listIterator();

        while(iterador.hasNext()){
            String color = iterador.next();         //Recupera el elemento de la lista
            iterador.set(color.toUpperCase());      //Convierte a mayusculas
        }
    }

    //Obtiene una sublista y elimina los elementos de la misma
    private static void eliminarElementosLista(List<String> lista, int indiceInicial, int indiceFinal){
        lista.subList(indiceInicial, indiceFinal).clear();
    }

    //Imprime la lista invertida
    private static void imprimirListaInvertida(List<String> lista){
        ListIterator<String> listIterator = lista.listIterator(lista.size());           //Empieza a iterar desde el último elemento

        while(listIterator.hasPrevious())
            System.out.printf("%s ", listIterator.previous());
    }
}

package com.qudopro.ch16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args){
        //Agregar elementos a un arreglo
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan"};
        List<String> listString = new ArrayList<>();

        for(String color : colores)
            listString.add(color);

        //Agrega los elementos en el arreglo1 al arreglo2
        String[] eliminarColores = {"Rojo", "Blanco", "Azul"};
        List<String> listString2 = new ArrayList<>();

        for(String color : eliminarColores)
            listString2.add(color);

        //Imprime el contenido de la lista
        System.out.println("ArrayList: ");
        for(int cuenta = 0; cuenta < listString.size(); cuenta++){
            System.out.printf("%s ", listString.get(cuenta));
        }
        System.out.println();

        //Eliminar elementos de la lista
        eliminarColor(listString, listString2);

        //Imprime el contenido de la lista
        System.out.println("\nArrayList después de eliminar colores: ");
        for(String color : listString){
            System.out.printf("%s ", color);
        }
    }

    //Eliminación de elementos en la colección por medio de un Iterador
    private static void eliminarColor(Collection<String> list1, Collection<String> list2){
        //Obtiene un iterador
        Iterator<String> iterador = list1.iterator();

        //Itera hasta que la colección no tenga elementos
        while(iterador.hasNext()){
            if(list2.contains(iterador.next())){
                iterador.remove();
            }
        }
    }
}
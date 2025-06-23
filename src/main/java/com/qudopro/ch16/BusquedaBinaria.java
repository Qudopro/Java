package com.qudopro.ch16;

import java.util.*;

public class BusquedaBinaria {
    public static void main(String[] args){
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan"};
        List<String> lista = new ArrayList<>(Arrays.asList(colores));

        //Ordenamiento obligatorio para realizar la busqueda
        Collections.sort(lista);
        System.out.println("Lista ordenada: " + lista);

        //Busqueda de valores en el objeto List
        imprimirBusqueda(lista, "Rojo");
        imprimirBusqueda(lista, "Negro");
    }
    //Realiza la busqueda y muestra el resultado
    private static void imprimirBusqueda(List<String> lista, String busqueda){
        int resultado = 0;

        System.out.println("Buscando el elemento " + busqueda + " en la lista...");
        resultado = Collections.binarySearch(lista, busqueda);

        if(resultado >= 0)
            System.out.println("Se encontro el objeto de busqueda en el indice: " + resultado);
        else
            System.out.println("No se encontraron los elementos");
    }
}

package com.qudopro.ch07;

import java.util.ArrayList;

public class ArrayListDemostracion {
    public static void main(String[] args){
        //Crea un objeto ArrayList vacio con una capacidad de 10 elementos
        ArrayList<String> elementosString = new ArrayList<String>();
        System.out.println("Tamano del ArrayList: " + elementosString.size());

        elementosString.add("Rojo");
        elementosString.add(0, "Amarillo");

        imprimirColeccion(elementosString);

        elementosString.add("Verde");
        elementosString.add("Amarillo");

        imprimirColeccion(elementosString);

        eliminarElementos(elementosString, "Verde");
        imprimirColeccion(elementosString);
        eliminarElementos(elementosString, 0);
        imprimirColeccion(elementosString);

        System.out.println("¿La coleccion tiene el color \"Rojo\"?\nR:\t" + (elementosString.contains("Rojo") ? "Verdadero" : "Falso"));
        System.out.println("Tamano del ArrayList: " + elementosString.size());    }

    private static void imprimirColeccion(ArrayList<String> coleccion){
        System.out.println("Se imprimiran los elementos de la coleccion");

        for(int i = 0; i < coleccion.size(); i++){              //for(String cadena : coleccion)
            System.out.printf("%s\s", coleccion.get(i));
        }

        System.out.println();
    }

    private static void eliminarElementos(ArrayList<String> coleccion, String valor){
        coleccion.remove(valor);
    }

    private static void eliminarElementos(ArrayList<String> coleccion, int valor){
        coleccion.remove(valor);
    }
}

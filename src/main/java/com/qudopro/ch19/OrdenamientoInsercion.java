package com.qudopro.ch19;

import java.security.SecureRandom;
import java.util.Arrays;

public class OrdenamientoInsercion {
    public static void ordenamietnoInsercion(int[] datos){
        for(int i = 1; i < datos.length; i++){
            int insercion = datos[i];           //Valor a insertar
            int moverElemento = i;              //Posición a colocar

            //Busca un lugar para colocar el elemento actual
            while(moverElemento > 0 && datos[moverElemento -1] > insercion){
                //Desplaza el elemento a la derecha
                datos[moverElemento] = datos[moverElemento-1];
                moverElemento--;
            }

            datos[moverElemento] = insercion;               //Coloca el elemento
            imprimirPasada(datos, i, moverElemento);
        }
    }

    public static void imprimirPasada(int[] datos, int pasada, int indice){
        System.out.printf("Coleccion despues de la pasada: %2d%n", pasada);

        //Imprime los elementos hasta el elemento dado
        for(int i = 0; i < indice; i++){
            System.out.printf("%d " , datos[i]);
        }

        //Intercambio
        System.out.printf("%d* ", datos[indice]);

        //Imprime los elementos desde el intercambio hasta el final
        for(int i = indice + 1; i < datos.length; i++){
            System.out.printf("%d ", datos[i]);
        }

        //Alineacion
        System.out.printf("%n");


        //Indica que esta ordenado
        for(int i = 0; i < pasada; i++){
            System.out.print("-- ");
        }

        System.out.println();
    }

    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();
        int datos[] = new int[10];

        for(int i = 0; i < datos.length; i++)
            datos[i] = 10 + secureRandom.nextInt(90);

        System.out.printf("Arreglo desordenado: %n%s%n%n", Arrays.toString(datos));

        ordenamietnoInsercion(datos);
        System.out.printf("Arreglo ordenado: %n%s%n%n", Arrays.toString(datos));
    }
}

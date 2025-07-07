package com.qudopro.ch19;

import java.security.SecureRandom;
import java.util.Arrays;

public class OrdenamientoSeleccion {
    public static void ordenamientoSeleccion(int[] datos){
        for(int i = 0; i < datos.length; i++){
            int masPequeno = i;

            //Iteracion interna para localizar el elemento mas pequeño
            for(int j = i+1; j < datos.length; j++){
                if(datos[j] < datos[masPequeno])
                    masPequeno = j;
            }

            intercambiar(datos, i, masPequeno);
            imprimirPasada(datos,i+1, masPequeno);
        }
    }

    public static void intercambiar(int[] datos, int primero, int segundo){
        int temporal = datos[primero];
        datos[primero] = datos[segundo];
        datos[segundo] = temporal;
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

        ordenamientoSeleccion(datos);
        System.out.printf("Arreglo ordenado: %n%s%n%n", Arrays.toString(datos));
    }
}

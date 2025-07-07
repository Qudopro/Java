package com.qudopro.ch19;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BusquedaLinealTest {
    public static int busquedaLineal(int datos[], int claveBusqueda){
        for(int i = 0; i < datos.length; i++){
            if(datos[i] == claveBusqueda)
                return i;                           //Devuelve el indice si se encontro la clave de busqueda
        }

        return -1;                                  //Devuelve valor centinela
    }

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        SecureRandom secure = new SecureRandom();
        int[] datos = new int[10];

        for(int i = 0; i < datos.length; i++)
            datos[i] = 10 + secure.nextInt(90);

        //Imprime el arreglo
        System.out.printf("%s%n%n", Arrays.toString(datos));

        System.out.print("Escriba un valor entero a buscar(-1 para terminar): ");
        int keyValue = entrada.nextInt();

        while(keyValue != -1){
            int index = busquedaLineal(datos, keyValue);

            if(index == -1)
                System.out.printf("%d no se encontro en la coleccion%n", keyValue);
            else
                System.out.printf("%d esta en la posicion %d del arreglo", keyValue, index);

            System.out.print("\nEscriba un valor entero a buscar(-1 para terminar): ");
            keyValue = entrada.nextInt();
        }
    }
}

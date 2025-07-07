package com.qudopro.ch19;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BusquedaBinariaTest {
    public static int busquedaBinaria(int[] datos, int claveBusqueda){
        int inferior = 0;
        int superior = datos.length-1;
        int medio = (inferior+superior+1)/2;

        int index = -1;

        //Algoritmo de busqueda
        do{
            System.out.print(elementosRestantes(datos, inferior, superior));

            //Imprime espacios para la alineacion
            for(int i = 0; i < medio; i++)
                System.out.print("   ");
            System.out.println("  *  ");                      //Indica el elemento medio

            if(claveBusqueda == datos[medio])
                index = medio;                              //Devuelve el indice medio
            else if(claveBusqueda < datos[medio])
                superior = medio - 1;                       //Elimina mitad superior
            else
                inferior = medio + 1;                       //Elimina mitad inferior

            medio = (inferior + superior + 1) / 2;          //nuevo calculo
        }while((inferior <= superior) && (index == -1));

        return index;
    }

    //Imprime los valores
    private static String elementosRestantes(int[] datos, int inferior, int superior){
        StringBuilder stringBuilder = new StringBuilder();
        //Imprime espacios para la alineacion
        for(int i = 0; i < inferior; i++)
            stringBuilder.append(" ");

        //Imprime los valores que quedan
        for(int i = 0; i <= superior; i++)
            stringBuilder.append(datos[i] + "  ");

        return String.format("%s%n", stringBuilder);
    }

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        SecureRandom secureRandom = new SecureRandom();

        //Poblado de la colección
        int[] datos = new int[15];
        for(int i = 0; i < datos.length; i++)
            datos[i]=10 + secureRandom.nextInt(90);

        System.out.println("Elementos en el arreglo:\t" + Arrays.toString(datos));
        //Ordenamiento
        Arrays.sort(datos);

        System.out.print("Escriba un valor a buscar o -1 para salir:\t");
        int keyValue = entrada.nextInt();

        while(keyValue != -1){
            int index = busquedaBinaria(datos, keyValue);

            if(index == -1)
                System.out.printf("%n%d no se encontro%n", keyValue);
            else
                System.out.printf("%n%d se encontro en el indice: %d%n", keyValue, index);

            System.out.print("Escriba un valor a buscar o -1 para salir");
            keyValue = entrada.nextInt();
        }
    }
}

package com.qudopro.ch19;

import java.security.SecureRandom;
import java.util.Arrays;

public class OrdenamientoCombinacion {
    //Comienza el ordenamiento
    public static void ordenamientoCombinacion(int[] datos){
        ordenarArreglo(datos, 0, datos.length - 1);             //Divide el arreglo
    }

    //Divide el arreglo. Ordena los subarreglo. Combina los arreglos
    private static void ordenarArreglo(int[] datos, int inferior, int superior){
        //Caso base
        if((superior- inferior) >= 1) {              //No es caso base
            int medio1 = (inferior + superior) / 2;             //Elemento medio
            int medio2 = medio1 + 1;                            //Calcula el siguiente elemento

            //Imprime en pantalla el paso de división
            System.out.printf("Division: %s%n",
                    subArregloString(datos, inferior, superior));

            System.out.printf("\t\t%s%n",
                    subArregloString(datos, inferior, medio1));
            System.out.printf("\t\t%s%n",
                    subArregloString(datos, medio2, superior));

            //Divide el arreglo a la mitad y ordena cada mitad
            ordenarArreglo(datos, inferior, medio1);
            ordenarArreglo(datos, medio2, superior);

            //Combina los arreglos
            combinar(datos, inferior, medio1, medio2, superior);
        }
    }

    //Combinación de dos arreglos ordenados
    private static void combinar(int[] datos, int izquierdo, int medio1, int medio2, int derecho){
        int indiceIzq = izquierdo;      //Indice subarreglo izquierdo
        int indiceDer = medio2;         //Indice subarreglo derecho
        int indiceCombinado = izquierdo;        //Indice en arreglo temporal
        int combinado[] = new int[datos.length];

        //Imprime los dos subarreglos
        System.out.printf("Combinacion: %s%n",
                subArregloString(datos, izquierdo, medio1));
        System.out.printf("Combinacion: %s%n",
                subArregloString(datos, medio2, derecho));

        //Combina los arreglos hasta llegar al final de uno de ellos
        while(indiceIzq <= medio1 && indiceDer <= derecho){
            //Coloca el menor de los elementos en el resultado
            if(datos[indiceIzq] <= datos[indiceDer])
                combinado[indiceCombinado++] = datos[indiceIzq++];
            else
                combinado[indiceCombinado++] = datos[indiceDer++];
        }

        //Si el arreglo izquierdo esta vacio
        if(indiceIzq == medio2){
            //Copia el resto del arreglo derecho
            while(indiceDer <= derecho)
                combinado[indiceCombinado++] = datos[indiceDer++];
        }else{      //El arreglo derecho esta vacio
            while(indiceIzq <= medio1)
                combinado[indiceCombinado++] = datos[indiceIzq++];
        }

        //Copia los valores devuelta al arreglo original
        for(int i = izquierdo; i <= derecho; i++)
            datos[i] = combinado[i];

        //Imprime el arreglo combinado
        System.out.printf("\t\t%s%n",
                subArregloString(datos, izquierdo, derecho));
    }

    //Imprimir valores
    private static String subArregloString(int[] datos, int inferior, int superior){
        StringBuilder temporal = new StringBuilder();

        //Imprime espacios para la alineacion
        for(int i = 0; i < inferior; i++)
            temporal.append(" ");

        //Imprime el resto de los elementos
        for(int i = inferior; i < superior; i++)
            temporal.append(" " + datos[i]);

        return temporal.toString();
    }

    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();
        int datos[] = new int[10];

        for(int i = 0; i < datos.length; i++)
            datos[i] = 10 + secureRandom.nextInt(90);

        System.out.printf("Arreglo desordenado: %n%s%n%n", Arrays.toString(datos));

        ordenamientoCombinacion(datos);
        System.out.printf("Arreglo ordenado: %n%s%n%n", Arrays.toString(datos));
    }
}

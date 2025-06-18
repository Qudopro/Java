package com.qudopro.ch07;

import java.util.Arrays;

public class DemostracionArrays {
    public static void main(String[] args){
        //Ordenamiento de forma ascendente
        double[] arregloDouble = {8.4, 9.3, 0.2, 7.9, 3.4};
        imprimirArreglo(arregloDouble);
        Arrays.sort(arregloDouble);
        imprimirArreglo(arregloDouble);

        //Llenar arreglo con valores
        int[] arregloInt = new int[10];
        imprimirArreglo(arregloInt);
        Arrays.fill(arregloInt, 7);
        imprimirArreglo(arregloInt);

        //Copiar arreglos
        int[] arregloTemp = new int[arregloInt.length];
        System.arraycopy(arregloInt,0,arregloTemp,0,arregloInt.length);
        imprimirArreglo(arregloTemp);

        //Compara si dos arreglos son iguales
        boolean b = Arrays.equals(arregloInt, arregloTemp);
        System.out.println("\n¿Los arreglos son iguales?\nR:\t" + (b ? "Verdadero":"Falso") );

        //Busqueda de valores
        int ubicacion = Arrays.binarySearch(arregloDouble, 0.2);
        if(ubicacion >= 0)
            System.out.printf("\nSe busco el valor %.2f en el arreglo.\nSu ubicacion fue:\t%d", 0.2, ubicacion);
        else
            System.out.println("\nNo se ha encontrado el elemento en el arreglo");
    }

    public static void imprimirArreglo(double[] arregloDouble){
        System.out.println("\nElementos del arreglo: ");

        for(double i : arregloDouble)
            System.out.printf("%.2f\t", i);
    }

    public static void imprimirArreglo(int[] arregloInt){
        System.out.println("\nElementos del arreglo: ");

        for(int i : arregloInt)
            System.out.printf("%d\t", i);
    }

}

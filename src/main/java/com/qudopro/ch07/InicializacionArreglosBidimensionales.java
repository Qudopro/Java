package com.qudopro.ch07;

public class InicializacionArreglosBidimensionales {
    public static void main(String[] args){
        int[][] arregloIntA = {{1,2}, {3,4,5}};
        int[][] arregloIntB = {{1,2,3}, {4}, {5,6,7,8,9}};

        System.out.println("Los valores del arreglo son: ");
        imprimirArreglo(arregloIntA);
        System.out.println("Los valores del arreglo son: ");
        imprimirArreglo(arregloIntB);
        System.out.println("Los valores del arreglo son: ");
        restablecerFila(arregloIntA, 1, 5);
        imprimirArreglo(arregloIntA);

        sumarElementosArreglo(arregloIntA);
        sumarElementosArreglo(arregloIntB);
    }

    public static void imprimirArreglo(int[][] arregloInt){
        for(int i = 0; i < arregloInt.length; i++){
            for(int j = 0; j < arregloInt[i].length;j++){
                System.out.printf("[%d][%d]:\t%d\t", i, j, arregloInt[i][j]);
            }
            System.out.println();
        }
    }

    public static void restablecerFila(int[][] arregloInt, int fila, int valor){
        for(int i = 0; i < arregloInt[fila].length; i++){
            arregloInt[fila][i] = valor;
        }
    }

    public static void sumarElementosArreglo(int[][] arregloInt){
        int total = 0;
        for(int i = 0; i < arregloInt.length; i++){
            for(int j = 0; j < arregloInt[i].length;j++){
                total += arregloInt[i][j];
            }
        }

        System.out.println("La suma de todos los valores del arreglo es:\t" + total);
    }
}

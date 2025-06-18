package com.qudopro.ch07;

public class InicializacionArreglos3 {
    public static final int LONGITUD_ARREGLO = 10;

    public static void main(String[] args){
        int[] arregloInt = new int[LONGITUD_ARREGLO];

        for(int i = 0; i < arregloInt.length; i++){
            arregloInt[i] = 2+2*i;
        }

        System.out.printf("%s%8s%n", "Indice", "Valor");
        for (int i = 0; i < arregloInt.length; i++){
            System.out.printf("%5d%8d%n", i, arregloInt[i]);
        }
    }
}

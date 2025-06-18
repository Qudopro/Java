package com.qudopro.ch07;

public class InicializacionArreglos {
    public static void main(String[] args){
        int[] arregloInt = new int[10];

        System.out.printf("%s%8s%n", "Indice", "Valor");
        for (int i = 0; i < arregloInt.length; i++){
            System.out.printf("%5d%8d%n", i, arregloInt[i]);
        }
    }
}

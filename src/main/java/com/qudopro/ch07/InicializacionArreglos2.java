package com.qudopro.ch07;

public class InicializacionArreglos2 {
    public static void main(String[] args){
        int[] arregloInt = {32, 27, 36,42,51,57,28,80,97,0};

        System.out.printf("%s%8s%n", "Indice", "Valor");
        for (int i = 0; i < arregloInt.length; i++){
            System.out.printf("%5d%8d%n", i, arregloInt[i]);
        }
    }
}

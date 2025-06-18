package com.qudopro.ch07;

public class AccesoArreglo {
    public static void main(String[] args){
        int[] arregloInt = {8,7,6,7,8,9,10,9,10,10};

        int total = 0;

        for(int i = 0; i < arregloInt.length; i++){
            total += arregloInt[i];
        }

        System.out.println("La suma del arreglo es:\t" + total);
    }
}

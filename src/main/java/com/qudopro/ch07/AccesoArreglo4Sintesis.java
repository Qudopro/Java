package com.qudopro.ch07;

public class AccesoArreglo4Sintesis {
    public static void main(String[] args){
        int[] respuestas = {1,2,3,4,5,5,4,3,2,1,1,2,3,4,5,5,4,3,2,1,10};
        int[] frecuencia = new int[6];

        for(int i = 0; i < respuestas.length; i++){
            try{
                ++frecuencia[respuestas[i]];
            }catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
                System.err.println("Error " + e);
            }
        }

        System.out.printf("%s%10s%n", "Calificacion", "Frecuencia");
        for(int i = 1; i < frecuencia.length; i++)
            System.out.printf("%6d%10d%n", i, frecuencia[i]);
    }
}

package com.qudopro.ch07;

public class AccesoArreglo2Grafico {
    public static void main(String[] args){
        int[] arregloInt = {0,0,0,0,0,0,1,2,4,1,5};

        for(int i = 0; i < arregloInt.length; i++){
            //Imprime la barra (00-09...90-99,100)
            if(i == 10)
                System.out.printf("%5d:\t", 100);
            else
                System.out.printf("%02d-%02d:\t", i*10, i*10+9);

            //Imprime asteriscos conforme al valor
            for(int j = 0; j < arregloInt[i]; j++)
                System.out.print("*");

            System.out.println();
        }
    }

}

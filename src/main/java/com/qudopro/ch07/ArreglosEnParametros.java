package com.qudopro.ch07;

public class ArreglosEnParametros {
    public static void main(String[] args){
        int[] arreglo = {1,2,3,4,5};

        System.out.println("Efectos de pasar una referencia a un arreglo completo");

        for(int i : arreglo)
            System.out.printf("%d\s", i);

        modificarArreglo(arreglo);

        System.out.println("\nEl arreglo se ha pasado a un metodo y sus valores ahora son: ");

        for(int i : arreglo)
            System.out.printf("%d\s", i);

        modificarValor(arreglo[0]);
        System.out.println("Un valor del arreglo se ha pasado a un metodo y sus valores ahora son: ");

        for(int i : arreglo)
            System.out.printf("%d\s", i);

        System.out.println();

        String cadena = "Hola";
        System.out.println(cadena);
        modificarCadena(cadena);
        System.out.println(cadena);
    }

    private static void modificarArreglo(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++)
            arreglo[i] *= 2;
    }

    private static void modificarValor(int valor){
        System.out.println("\nValor original:\t"+ valor);
        valor *= 2;
        System.out.println("Se ha cambiado el valor de la variable a: " + valor);
    }

    private static void modificarCadena(String cadena){
        cadena = "Hola a todos";
    }
}

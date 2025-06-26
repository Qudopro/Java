package com.qudopro.ch17;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args){
        int[] valores = {3,10,6,1,4,8,2,5,8,7};

        //Imprimir contenido usando IntStream
        System.out.println("Se imprimira el contenido del arreglo");
        IntStream.of(valores)
                .forEach(x -> System.out.printf("%d ", x));
        System.out.println();

        //Operaciones terminales aritmeticas
        System.out.println("Cuenta los elementos de la coleccion: " + IntStream.of(valores).count());
        System.out.println("Valor minimo de la coleccion: " + IntStream.of(valores).min().getAsInt());
        System.out.println("Valor maximo de la coleccion: " + IntStream.of(valores).max().getAsInt());
        System.out.println("Suma de los elementos de la coleccion: " + IntStream.of(valores).sum());
        System.out.println("Promedio de los elementos de la coleccion: " + IntStream.of(valores).average().getAsDouble());
        //Summary Statistics
        System.out.println("Summary Statistics: " + IntStream.of(valores).summaryStatistics());
        System.out.println("Suma con reduce de los elementos de la coleccion: " + IntStream.of(valores).reduce(
                0, (x,y) -> x+y)
        );
        System.out.println("Suma de los cuadrados de los elementos de la coleccion con reduce: " + IntStream.of(valores).reduce(
                0, (x,y)->x+y*y
        ));
        System.out.println("Producto de los elementos de la coleccion con reduce: " + IntStream.of(valores).reduce(
                1, (x,y) -> x*y
        ));

        //Ordenamiento
        System.out.println("\n***************************");
        System.out.println("Valores pares ordenados de la coleccion");
        IntStream.of(valores)
                .filter(x -> x%2 == 0)                  //Considerar solo valores pares
                .sorted()
                .forEach(x -> System.out.printf("%d ", x));

        //Crear una nueva coleccion
        System.out.println("\n***************************");
        System.out.println("Valores impares multiplicados por 10 y ordenados");
        IntStream.of(valores)
                .filter(x -> x%2!=0)
                .map(x -> x*10)
                .sorted()
                .forEach(x -> System.out.printf("%d ", x));

        //Rangos
        System.out.println("\n***************************");
        System.out.println("Suma de los valores 1-9 con range: " + IntStream.range(1, 10).sum());

        System.out.println("Suma de los valores 1-10 con range: " + IntStream.rangeClosed(1,10).sum());


    }
}

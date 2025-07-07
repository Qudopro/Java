package com.qudopro.ch20;

public class MetodosGenericosMaximumNumbers {
    public static void main(String[] args){
        System.out.printf("Maximum of %d, %d and %d is: %d%n%n", 3,4,5, maximum(3,4,5));
        System.out.printf("Maximum of %.1f, %.1f and %.1f is: %.1f%n%n", 3.3,4.4,5.5, maximum(3.3,4.4,5.5));
        System.out.printf("Maximum of %s, %s and %s is: %s%n%n", "orange","beige","red", maximum("orange","beige","red"));
    }

    //ComparableT es el limite superior del parametro de tipo
    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;
        if(y.compareTo(max) > 0)
            max = y;

        if(z.compareTo(max) > 0)
            max = z;

        return max;
    }
}
/*
Comparable<T> permite comparar dos objetos de una misma clase.
    0 -> Ambos objetos son iguales
    Negativo -> Objeto1 es menor que el Objeto2
    Positivo -> Objeto1 es mayor que el Objeto2

Comparable permite ordenar y buscar objetos en Collections
*/

package com.qudopro.ch17;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArreglosStreamTwo {
    public static void main(String[] args){
        String[] colores = {"Magenta", "Rojo", "Azul", "Blanco", "Cyan"};

        System.out.printf("Valores originales: %s%n", Arrays.asList(colores));


        //Convertir a mayusculas
        System.out.printf("Valores modificados a mayusculas: %s%n",
                    Arrays.stream(colores)
                            .map(String::toUpperCase)           //Referencia a un metodo
                            .collect(Collectors.toList())
                );

        System.out.println("String::toUpperCase ==  (String s) -> {s.toUpperCase();}");

        //Filtro y ordenamiento ascendente
        System.out.printf("Valores mayores a 'm': %s%n",
                Arrays.stream(colores)
                        .filter(x -> x.compareToIgnoreCase("m") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList())
            );

        //Filtro y ordenamiento descendente
        System.out.printf("Valores mayores a 'm': %s%n",
                Arrays.stream(colores)
                        .filter(x -> x.compareToIgnoreCase("m") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList())
            );
    }
}

/*
Invocación a método de instancia con argumento de la expresión lambda
String::toUpperCase
Expresion lambda de un parámetro que invoca a un método de instancia con el argumento de la expresion lambda.

Metodo de instancia que se invoca sobre un objeto en especifico
System.out::println
Expresion lambda de un parámetro que invoca a un metodo de instancia sobre un objeto dado

Invocación a un método static con el argumento de la expresión lambda como argumento del método
Math::sqrt
Expresión lambda de un parámetro que invoca a un método static de una clase y el argumento de la expresion lambda se pasa al método como argumento

Referencia a un constructor
TreeMap::new
Expresion lambda que crea un nuevo objeto invocando al constructor sin argumentos de la clase


 */
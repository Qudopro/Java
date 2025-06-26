package com.qudopro.ch17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArreglosStream {
    public static void main(String[] args){
        Integer[] valores = {2,9,8,5,0,3,7,1,4,8,6};

        //Mostrar los valores originales
        System.out.printf("Valores originales: %s%n", Arrays.asList(valores));

        //Ordenamiento ascendente
        System.out.printf("Valores ordenados de forma ascendente: %s%n",
                    Arrays.stream(valores)
                            .sorted()
                            .collect(Collectors.toList())
                );

        //Valores mayores a un numero determinado
        List<Integer> greatherFour =
                Arrays.stream(valores)
                        .filter(x -> x > 4)
                        .collect(Collectors.toList());

        //Valores mayores a un numero determinado y ordenado
        System.out.printf("Valores mayores que 4 ordenados de forma ascendente: %s%n",
                greatherFour.stream()
                        .sorted()
                        .collect(Collectors.toList())
                );
    }
}

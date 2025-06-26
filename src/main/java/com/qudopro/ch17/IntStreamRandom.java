package com.qudopro.ch17;

import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntStreamRandom {
    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();
        System.out.printf("%-6s%s%n", "Cara", "Frecuencia");
        secureRandom.ints(6_000_000,1,7)    //Generación de IntStream
                .boxed()                        //Convierte a Integer
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),            //Devuelve el argumento de apply de Function. Valores actuales = Claves del objeto Map
                                Collectors.counting()
                        )
                        //Objeto generado;:         Map<Integer, Long>
                ).forEach(
                        (cara,frecuencia)->{
                            System.out.printf("%-6d%d%n", cara,frecuencia);
                        }
                );

    }
}

//Concordancia: Contar el numero de ocurrencias de cada palabra en un archivo y mostrar un resumen
package com.qudopro.ch17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class Concordancia {
    public static final String DIRECTORY = "/Users/dc/Downloads/";
    public static final String FILE = "ejemplo.txt";

    public static void main(String[] args) throws IOException{
        //Expresion regular con coincidencia de 1 o más espacios
        Pattern pattern = Pattern.compile("\\s+");

        //Cuenta las ocurrencias y las ordena por palabra
        Map<String, Long> cuentaPalabras =
                Files.lines(Paths.get(DIRECTORY.concat(FILE)))          //Lee las lineas del archivo
                        .map(line -> line.replaceAll("(?!')\\p{P}", ""))       //Eliminación de puntuacion.
                                                                                    // \\p{P} -> Cualquier caracter de puntuacion
                        .flatMap(line -> pattern.splitAsStream(line))       //Divide la linea de texto en sus palabras individuales
                        .collect(Collectors.groupingBy(
                                String::toLowerCase,                         //Clasificador. Function que genera las claves del Map
                                TreeMap::new,                               //Fabrica de Map (TreeMap<String, Long>. Implementa a Supplier y devuelve un Map
                                Collectors.counting()                       //Collector de flujo descendente. Ocurrencias de cada clave
                        ));

        //Muestra las palabras agrupadas por letra inicial. Itearcion del objeto Map
        cuentaPalabras.entrySet().stream()
                .collect(Collectors.groupingBy(
                        entry -> entry.getKey().charAt(0),      //Clasificador. Genera las claves
                        TreeMap::new,               //Fabrica de Map. Genera un objeto Map. Implementa a Supplier
                        Collectors.toList()         //Collector. Recupera los objetos List de Map.Entry
                ))      //Valor devuelto:           Map<Character, List<Map.Entry<String, Long>>>
                .forEach(
                        (letra, listaPalabras) -> {
                            System.out.println(letra);
                            listaPalabras.stream()
                                    .forEach(
                                            x -> System.out.printf(
                                                    "%13s: %d%n", x.getKey(), x.getValue()
                                            )
                                    );
                        }

                );
    }
}

/*
Supplier -> Metodo T get(); Se usa para crear un objeto colección.
TreeMap devuelve un objeto Map con las claves ordenadas

 */
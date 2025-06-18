package com.qudopro.ch15;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class InformacionArchivos {
    private String ruta1 = "/Users/dc/Downloads/";

    public static void main(String[] args) throws IOException {
        System.out.println("La forma en la que se separan los directorios es: " + File.separator);
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escriba el nombre del archivo o directorio");
        Path ruta = Paths.get(entrada.nextLine());
        if(Files.exists(ruta)){
            System.out.println("El recurso existe con el nombre: " + ruta.getFileName());
            System.out.println("El recurso es un directorio: " + Files.isDirectory(ruta));
            System.out.println("El recurso tiene ruta absoluta: " + ruta.isAbsolute());
            System.out.println("Ultima modificacion del archivo: " + Files.getLastModifiedTime(ruta));
            System.out.println("Tamano del archivo: " + Files.size(ruta));
            System.out.println("La ruta absoluta de la ruta proporcionada es: " + ruta.toAbsolutePath());

            if(Files.isDirectory(ruta)){
                System.out.println("Contenido del directorio");
                DirectoryStream<Path> directory = Files.newDirectoryStream(ruta);

                for(Path p : directory)
                    System.out.println(p);
            }
        }else{
            System.out.println("El recurso proporcionado no existe!");
        }
    }
}

package com.qudopro.ch15;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearArchivosSerializables {
    private static ObjectOutputStream salida;
    private static String path = "/Users/dc/Downloads/";
    private static String file = "Archivo.txt";

    public static void main(String[] args){
        abrirArchivo();
        escribirEnArchivo();
        cerrarArchivo();
    }

    //Intenta abrir el archivo
    private static void abrirArchivo(){
        try{
            salida = new ObjectOutputStream(Files.newOutputStream(Paths.get(path.concat(file))));
        }catch (IOException e){
            System.err.println("Error al intentar abrir el archivo");
            System.exit(1);
        }
    }

    //Intenta escribir en el archivo
    private static void escribirEnArchivo() {
        Scanner entrada = new Scanner(System.in);
        System.out.printf("%s%n%s%n",
                "Escriba un numero de cuenta, nombre, apellido y saldo",
                "Para terminar la entrada escriba el indicador de fin de archivo"
        );

        while (entrada.hasNext()) {
            try {
                CuentaSerializable cuenta = new CuentaSerializable(
                        entrada.nextInt(), entrada.next(), entrada.next(), entrada.nextDouble()
                );
                salida.writeObject(cuenta);
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo");
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Entrada no valida");
                entrada.nextLine();                          //Descarta la entrada
            }

            System.out.print("");
        }
    }

    //Intenta cerrar el archivo
    private static void cerrarArchivo(){
        try{
            if(salida != null)
                salida.close();
        }catch (IOException e){
            System.err.println("Error al cerrar el archivo");
        }
    }
}

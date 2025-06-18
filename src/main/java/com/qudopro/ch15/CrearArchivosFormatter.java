package com.qudopro.ch15;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearArchivosFormatter {
    private static Formatter salida;                //Permite enviar texto a un archivo
    private static String path = "/Users/dc/Downloads/";
    private static String file = "Archivo.txt";
    public static void main(String[] args){
        abrirArchivo();
        escribirEnArchivo();
        cerrarArchivo();
    }

    //Permite abrir el archivo
    private static void abrirArchivo(){
        String fileName = path.concat(file);
        try{
            salida = new Formatter(fileName);
        }catch (SecurityException e){
            System.err.println("Permisos de escritura denegado");
            System.exit(1);
        }catch (FileNotFoundException e){
            System.err.println("Error al intentar abrir el archivo");
            System.exit(1);
        }
    }

    //Permite escribir en el archivo
    private static void escribirEnArchivo(){
        Scanner entrada = new Scanner(System.in);
        System.out.printf("%s%n%s%n",
                "Escriba un numero de cuenta, nombre, apellido y saldo",
                "Para terminar la entrada escriba el indicador de fin de archivo"
                );

        while(entrada.hasNext()){
            try{
                salida.format("%d %s %s %.2f%n",
                        entrada.nextInt(), entrada.next(), entrada.next(), entrada.nextDouble()
                        );
            }catch(FormatterClosedException e){
                System.err.println("Error al escribir en el archivo");
                break;
            }catch(NoSuchElementException e){
                System.err.println("Entrada no valida");
                entrada.nextLine();                     //Descarta la entrada
            }

            System.out.print("");
        }
    }

    //Permite cerrar el archivo
    private static void cerrarArchivo(){
        if(salida != null){
            salida.close();
        }
    }
}

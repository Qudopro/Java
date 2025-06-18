package com.qudopro.ch15;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LeerArchivosScanner {
    private static String path = "/Users/dc/Downloads/";
    private static String file = "Archivo.txt";
    private static Scanner entrada;

    public static void main(String[] args){
        abrirArchivo();
        leerArchivo();
        cerrarArchivo();
    }
    //Abre el archivo
    private static void abrirArchivo(){
        try{
            entrada = new Scanner(Paths.get(path.concat(file)));
        } catch (IOException e) {
            System.err.println("Error al intentar abrir el archivo");
            System.exit(1);
        }
    }

    //Permite leer el archivo
    private static void leerArchivo(){
        System.out.printf("%-10s%-12s%-12s%10s%n", "Cuenta", "Nombre", "Apellido", "Saldo");

        try{
            while(entrada.hasNext()){
                System.out.printf("%-10d%-12s%-12s%10.2f%n",
                        entrada.nextInt(), entrada.next(), entrada.next(), entrada.nextDouble()
                        );
            }
        }catch (NoSuchElementException e){
            System.err.println("Archivo con datos inconsistentes");
            e.printStackTrace();
            System.exit(1);
        }catch(IllegalStateException e){
            System.err.println("Error al leer el archivo. El archivo se cerro inesperadamente");
            System.exit(1);
        }
    }

    //Permite cerrar el archivo
    private static void cerrarArchivo(){
        if(entrada != null){
            entrada.close();
        }
    }
}

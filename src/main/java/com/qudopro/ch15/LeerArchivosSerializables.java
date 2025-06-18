package com.qudopro.ch15;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class LeerArchivosSerializables {
    private static String path = "/Users/dc/Downloads/";
    private static String file = "Archivo.txt";
    private static ObjectInputStream entrada;

    public static void main(String[] args){
        abrirArchivo();
        leerArchivo();
        cerrarArchivo();
    }
    //Abre el archivo
    private static void abrirArchivo(){
        try{
            entrada = new ObjectInputStream(Files.newInputStream(Paths.get(path.concat(file))));
        } catch (IOException e) {
            System.err.println("Error al intentar abrir el archivo");
            System.exit(1);
        }
    }

    //Permite leer el archivo
    private static void leerArchivo(){
        System.out.printf("%-10s%-12s%-12s%10s%n", "Cuenta", "Nombre", "Apellido", "Saldo");

        try{
            while(true){
                CuentaSerializable cuenta = (CuentaSerializable)entrada.readObject();

                System.out.printf("%-10d%-12s%-12s%10.2f%n",
                        cuenta.getCuenta(), cuenta.getNombre(), cuenta.getApellido(), cuenta.getSaldo()
                );
            }
        }catch(EOFException e){
            System.err.println("No hay mas registros que leer");
        }catch (ClassNotFoundException e){
            System.err.println("Tipo de objeto no valido");
            System.exit(1);
        }catch (IOException e){
            System.err.println("Error al intentar leer el archivo");
            System.exit(1);
        }
    }

    //Permite cerrar el archivo
    private static void cerrarArchivo(){
        try{
            if(entrada != null)
                entrada.close();
        }catch (IOException e){
            System.err.println("Error al intentar cerrar el archivo");
            System.exit(1);
        }
    }
}

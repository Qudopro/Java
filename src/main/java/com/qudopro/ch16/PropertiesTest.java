package com.qudopro.ch16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
    public static String directory = "/Users/dc/Downloads";

    public static void main(String[] args){
        Properties properties = new Properties();

        //Establecer valores
        properties.setProperty("color", "azul");
        properties.setProperty("anchura", "200");

        System.out.println("Se muestra contenido del objeto Properties");
        imprimirPropiedades(properties);

        //Reemplazar valores de claves en properties
        properties.setProperty("color", "rojo");
        System.out.println("Se muestra contenido del objeto Properties");
        imprimirPropiedades(properties);
        //Guardar datos de tabla
        guardarPropiedades(properties);
        //Limpieza de la tabla
        properties.clear();
        //Cargar datos en tabla
        System.out.println("Se muestra contenido del objeto Properties");
        imprimirPropiedades(properties);
        cargarPropiedades(properties);

        //Obtiene un valor de una propiedad
        Object valor = properties.getProperty("color");
        if(valor != null)
            System.out.println("Valor para la propiedad \"color\" es: " + valor);
        else
            System.out.println("No hay un valor asociado para la propiedad \"color\"");
    }

    //Guardar las propiedades en un archivo
    private static void guardarPropiedades(Properties properties){
        try{
            FileOutputStream output = new FileOutputStream(directory.concat("properties.dat"));
            properties.store(output, "Propiedades");
            output.close();
            System.out.println("Se han guardado exitosamente las propiedades");
            imprimirPropiedades(properties);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Carga las propiedades
    private static void cargarPropiedades(Properties properties){
        try{
            FileInputStream fileInputStream = new FileInputStream(directory.concat("properties.dat"));
            properties.load(fileInputStream);
            fileInputStream.close();
            System.out.println("Se han cargado exitosamente las propiedades");
            imprimirPropiedades(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Imprime las propiedades
    private static void imprimirPropiedades(Properties properties){
        Set<Object> keys = properties.keySet();

        for(Object k : keys){
            System.out.printf("%s\t%s\n", k, properties.getProperty((String)k));
        }

        System.out.println();
    }
}

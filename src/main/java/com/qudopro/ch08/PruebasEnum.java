package com.qudopro.ch08;

import java.util.EnumSet;


public class PruebasEnum {
    public static void main(String[] args){
        System.out.println("Todos los libros generados: ");

        //Imprime todas las constantes Enum
        for(LibrosEnum libros : LibrosEnum.values())
            System.out.printf("%-10s%-45s%s%n", libros, libros.obtenerTitulo(), libros.obtenerAno());

        System.out.println("\n Rango de las constantes Enum");

        for(LibrosEnum libros : EnumSet.range(LibrosEnum.JHTP, LibrosEnum.CHTP))
            System.out.printf("%-10s%-45s%s%n", libros, libros.obtenerTitulo(), libros.obtenerAno());

    }
}

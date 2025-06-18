package com.qudopro.ch07;

public class PruebaLibroCalificacionesBidimensional {
    public static void main(String[] args){
        int[][] arregloBidimensional = {{87,96,70},{68,87,90},{99,100,99}};

        LibroCalificacionesBidimensional libroCalificacionesBidimensional = new LibroCalificacionesBidimensional("CS101", arregloBidimensional);

        System.out.println("Calificaciones para la clase:\t" + libroCalificacionesBidimensional.obtenerNombreCurso());
        libroCalificacionesBidimensional.procesarCalificaciones();
    }
}

package com.qudopro.ch07;

public class PruebaLibroCalificaciones {
    public static void main(String[] args){
        int[] calificaciones ={87,88,68,94,100,78,85,91,76,87};

        LibroCalificaciones libroCalificaciones = new LibroCalificaciones("CS101", calificaciones);

        System.out.printf("Calificaciones para el curso:\t%s%n", libroCalificaciones.obtenerNombreCurso());
        libroCalificaciones.procesarCalificaciones();
    }
}

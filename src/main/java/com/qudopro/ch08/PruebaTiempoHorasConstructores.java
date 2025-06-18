package com.qudopro.ch08;

public class PruebaTiempoHorasConstructores {
    public static void main(String[] args){
        TiempoHoras tiempoHoras = new TiempoHoras();
        TiempoHoras tiempoHoras1 = new TiempoHoras(21);
        TiempoHoras tiempoHoras2 = new TiempoHoras(21,23);
        TiempoHoras tiempoHoras3 = new TiempoHoras(21,23,43);
        TiempoHoras tiempoHoras4 = new TiempoHoras(tiempoHoras);

        mostrarTiempo("Objeto tiempoHoras:\t", tiempoHoras);
        mostrarTiempo("Objeto tiempoHoras1:\t", tiempoHoras1);
        mostrarTiempo("Objeto tiempoHoras2:\t", tiempoHoras2);
        mostrarTiempo("Objeto tiempoHoras3:\t", tiempoHoras3);
        mostrarTiempo("Objeto tiempoHoras4:\t", tiempoHoras4);
    }

    private static void mostrarTiempo(String message, TiempoHoras tiempoHoras){
        System.out.println(message);
        System.out.printf("Tiempo universal:\t%s%nTiempo estandar:\t%s%n", tiempoHoras.horaUniversal(), tiempoHoras);
    }
}

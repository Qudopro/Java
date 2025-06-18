package com.qudopro.ch08;

public class PruebaTiempoHoras {
    public static void main(String[] args){
        TiempoHoras tiempoHoras = new TiempoHoras();

        mostrarTiempo("Despues de crear el objeto TiempoHoras", tiempoHoras);

        tiempoHoras.establecerTiempoHoras(23,32,45);
        mostrarTiempo("Despues de modificar el objeto TiempoHoras", tiempoHoras);

        try{
            tiempoHoras.establecerTiempoHoras(32,32,32);
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        mostrarTiempo("Despues de modificar el objeto TiempoHoras con valores invalidos", tiempoHoras);
    }

    private static void mostrarTiempo(String message, TiempoHoras tiempoHoras){
        System.out.println(message);
        System.out.printf("Tiempo universal:\t%s%nTiempo estandar:\t%s%n", tiempoHoras.horaUniversal(), tiempoHoras);
    }

}

package com.qudopro.ch18;

public class RecursividadTorresHanoi {
    //Mueve los discos de una torre a otra
    public static void resolverTorres(int discos, int agujaOrigen, int agujaDestino, int agujaTemporal) {
        //Caso base - Mover un solo disco
        if (discos == 1) {
            System.out.printf("%n%d --> %d", agujaOrigen, agujaDestino);
            return;
        }

        //Mueve (discos - 1) discos de origen a temporal como destino
        resolverTorres(discos - 1, agujaOrigen, agujaTemporal, agujaDestino);

        //Mueve el último disco de origen a destino
        System.out.printf("%n%d --> %d", discos, agujaOrigen, agujaDestino);

        //Mueve (discos - 1) discos de temporal a destino como origen
        resolverTorres(discos - 1, agujaTemporal, agujaDestino, agujaOrigen);
    }

    public static void main(String[] args) {
        int agujaInicial = 1;
        int agujaFinal = 3;
        int agujaTemporal = 2;
        int discos = 3;

        //Mueve todos los discos
        resolverTorres(discos, agujaInicial, agujaFinal, agujaTemporal);
    }
}
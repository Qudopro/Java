package com.qudopro.ch07;

import java.security.SecureRandom;

public class PaqueteDeCartas {
    private Carta[] paquete;            //Arreglo de Cartas
    private int cartaActual;            //Indice de la siguiente carta a reportir
    private static final int NUMERO_CARTAS = 52;

    private static final SecureRandom SECURE = new SecureRandom();

    public PaqueteDeCartas(){
        String[] caras = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Joker", "Reina", "Rey"};
        String[] palos = {"Corazones", "Treboles", "Picas", "Diamantes"};

        paquete = new Carta[NUMERO_CARTAS];
        cartaActual = 0;

        //Llena el paquete de cartas con objetos Carta
        for(int i = 0; i < paquete.length; i++){
            paquete[i] = new Carta(caras[i%13], palos[i/13]);
        }
    }

    //Barajea el paquete de cartas con algoritmo de una pasada
    public void barajear(){
        //Inicializa la carta a repartir a 0
        cartaActual = 0;
        //Intercambia la carta
        for(int i = 0; i < paquete.length; i++){
            //Selecciona un numero aleatorio 0-51
            int siguienteCarta = SECURE.nextInt(NUMERO_CARTAS);

            Carta cartaTemporal = paquete[i];
            paquete[i] = paquete[siguienteCarta];
            paquete[siguienteCarta] = cartaTemporal;
        }
    }

    //Repartir una carta
    public Carta repartirCarta(){
        //Determina si quedan cartas a repartir
        if(cartaActual < paquete.length)
            return paquete[cartaActual++];
        else
            return null;
    }
}

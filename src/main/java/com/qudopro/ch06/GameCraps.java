package com.qudopro.ch06;

import java.security.SecureRandom;

public class GameCraps {
    //Generador de numeros aleatorios
    private static final SecureRandom security = new SecureRandom();

    //Enums. Estados de juego
    private enum Estado{CONTINUA, GANO, PERDIO};

    //Tiros Comunes
    private static final int DOS_UNOS = 2;
    private static final int TRES = 3;
    private static final int SIETE = 7;
    private static final int ONCE = 11;
    private static final int DOCE = 12;

    public static void main(String[] args){
        int miPunto = 0;
        Estado estadoJuego;
        int suma = tirarDados();

        switch(suma){
            case SIETE:
            case ONCE:
                estadoJuego = Estado.GANO;
                break;
            case DOS_UNOS:
            case TRES:
            case DOCE:
                estadoJuego = Estado.PERDIO;
                break;
            default:
                estadoJuego = Estado.CONTINUA;
                miPunto = suma;
                System.out.println("Mi punto es:\t" + miPunto);
                break;
        }

        while(estadoJuego == Estado.CONTINUA) {
            suma = tirarDados();

            if (suma == miPunto)
                estadoJuego = Estado.GANO;
            else {
                if (suma == SIETE)
                    estadoJuego = Estado.PERDIO;
            }
        }

        if(estadoJuego == Estado.GANO)
            System.out.println("Usted ha ganado");
        else
            System.out.println("Usted ha perdido");
    }

    private static int tirarDados(){
        int dado1 = 1 + security.nextInt(6);
        int dado2 = 1 + security.nextInt(6);
        int suma = dado1 + dado2;

        System.out.printf("El jugador tiro %d y %d, para un total de: %d%n", dado1, dado2, suma);

        return suma;
    }
}

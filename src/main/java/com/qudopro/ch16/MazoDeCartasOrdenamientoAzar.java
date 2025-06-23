package com.qudopro.ch16;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Carta{
    public static enum Cara {As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Ocho, Nueve, Diez, Joker, Reina, Rey};
    public static enum Palo{Corazones, Diamantes, Espadas, Treboles};

    private final Cara cara;
    private final Palo palo;

    public Carta(Cara cara, Palo palo){
        this.cara = cara;
        this.palo = palo;
    }

    public Cara obtenerCara(){
        return cara;
    }

    public Palo obtenerPalo(){
        return palo;
    }

    public String toString(){
        return String.format("%s de %s", cara, palo);
    }
}

public class MazoDeCartasOrdenamientoAzar {
    private List<Carta> lista;          //Objeto que almacena la carta

    public MazoDeCartasOrdenamientoAzar(){
        Carta[] mazo = new Carta[52];
        int cuenta = 0;                 //Numero de cartas

        //Llenar el mazo de cartas
        for(Carta.Palo palo : Carta.Palo.values()){
            for(Carta.Cara cara : Carta.Cara.values()){
                mazo[cuenta] = new Carta(cara, palo);
                ++cuenta;
            }
        }

        lista = Arrays.asList(mazo);
        Collections.shuffle(lista);
    }

    //Imprime el mazo
    public void imprimirCartas(){
        //52 cartas en 2 columnas
        for(int i = 0; i < lista.size(); i++){
            System.out.printf("%-19s%s", lista.get(i), (
                    (i+1)%4==0 ? "\n" : " "
                    ));
        }
    }

    public static void main(String[] args){
        MazoDeCartasOrdenamientoAzar mazo = new MazoDeCartasOrdenamientoAzar();
        mazo.imprimirCartas();
    }
}

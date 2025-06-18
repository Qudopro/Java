package com.qudopro.ch07;

public class Carta {
    private final String cara;
    private final String palo;

    public Carta(String cara, String palo){
        this.cara = cara;
        this.palo = palo;
    }

    //Devuelve la represetanción String de la carta
    @Override
    public String toString(){
        return cara + "\sde\s" + palo;
    }
}

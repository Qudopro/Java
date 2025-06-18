package com.qudopro.ch07;

public class PruebaPaqueteDeCartas {
    public static void main(String[] args){
        PaqueteDeCartas paqueteDeCartas = new PaqueteDeCartas();
        paqueteDeCartas.barajear();

        for(int i = 1; i <= 52; i++){
            System.out.printf("%-23s", paqueteDeCartas.repartirCarta());

            if(i % 4 == 0)
                System.out.println();
        }
    }

}

package com.qudopro.ch06;

public class AlcanceCampos {
    private static int x = 1;

    public static void main(String[] args){
        int x = 5;

        System.out.println("El valor de la variable x es:\t" + x);

        usarVariableLocal();
        usarVariableInstancia();
        usarVariableLocal();
        usarVariableInstancia();
        usarVariableLocal(x);
        System.out.println("El valor de la variable x es:\t" + x);
    }

    //Crea e inicializa la variable local durante cada llamada
    public static void usarVariableLocal(){
        int x = 25;

        System.out.println("Uso de la variable local x:\t" + x);
        ++x;
        System.out.println("Uso de la variable local x:\t" + x);
    }

    //Crea e inicializa la variable local durante cada llamada
    public static void usarVariableLocal(int x){
        ++x;
        System.out.println("Uso de la variable local por parametro x:\t" + x);
    }

    //Crea y modifica la variable de instancia
    public static void usarVariableInstancia(){
        System.out.println("Uso de la variable instancia x:\t" + x);
        x*=10;
        System.out.println("Uso de la variable instancia x:\t" + x);
    }
}

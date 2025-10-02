package com.qudopro.ch02;

public class PatronDamas {
    public static void main(String[] args){
        String filaPar = "* ".repeat(8);
        String filaImpar = " *".repeat(8);

        for(int i = 0; i < 8; i++){
            if(i%2 == 0)
                System.out.println(filaPar);
            else
                System.out.println(filaImpar);
        }

    }
}

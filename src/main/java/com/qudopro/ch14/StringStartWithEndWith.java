package com.qudopro.ch14;

public class StringStartWithEndWith {
    public static void main(String[] args){
        String[] cadena = {"empezo", "empezando", "termino", "terminando"};

        for(String s : cadena) {
            if (s.startsWith("em"))
                System.out.println(s);
        }
        System.out.println();

        for(String s : cadena) {
            if (s.startsWith("pez", 2))
                System.out.println(s);
        }
        System.out.println();

        for(String s : cadena){
            if(s.endsWith("do"))
                System.out.println(s);
        }
    }
}

package com.qudopro.ch14;

public class StringIndex {
    public static void main(String[] args){
        String letras = "abcdefghijklmnopqrstuvwxyz";
        //INDEX OF
        System.out.println("'c' se encuentra en el indice: " + letras.indexOf('c'));
        System.out.println("'a' se encuentra en el indice: " + letras.indexOf('a', 1));

        //LAST INDEX OF
        System.out.println("'c' se encuentra en el indice " + letras.lastIndexOf('c'));
        System.out.println("'a' se encuentra en el indice " + letras.lastIndexOf('a', 25));
        System.out.println("'$' se encuentra en el indice " + letras.lastIndexOf('$'));

        //INDEX OF PARA LOCALIZAR CADENAS
        System.out.println("'def' se encuentra en el indice: " + letras.indexOf("def"));
        System.out.println("'def' se encuentra en el indice: " + letras.indexOf("def", 7));
        System.out.println("'ola' se encuentra en el indice: " + letras.indexOf("ola"));

        //LAST INDEX OF PARA LOCALIZAR CADENAS
        System.out.println("'def' se encuentra en el indice: " + letras.lastIndexOf("def"));
        System.out.println("'def' se encuentra en el indice: " + letras.lastIndexOf("def", 25));
        System.out.println("'ola' se encuentra en el indice: " + letras.lastIndexOf("ola"));
    }
}

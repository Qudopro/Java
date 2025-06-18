package com.qudopro.ch14;

public class StringBuilderConstructor {
    public static void main(String[] args){
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder(10);
        StringBuilder builder3 = new StringBuilder("Hola");

        System.out.println(builder1);
        System.out.println(builder2);
        System.out.println(builder3);
    }
}

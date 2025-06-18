package com.qudopro.ch14;

public class StringBuilderCapacityLength {
    public static void main(String[] args){
        StringBuilder builder1 = new StringBuilder("Hola mundo!");

        System.out.println(builder1);
        System.out.println("Capacidad: " + builder1.capacity());
        System.out.println("Longitud: " + builder1.length());

        builder1.ensureCapacity(100);
        builder1.setLength(150);

        System.out.println(builder1);
        System.out.println("Capacidad: " + builder1.capacity());
        System.out.println("Longitud: " + builder1.length());
    }
}

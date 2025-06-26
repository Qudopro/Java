package com.qudopro.ch17;

@FunctionalInterface
public interface GenerateFuncional {
    void generate();

    default void generateImplementacion(){
        System.out.println("Hola");
    }
}

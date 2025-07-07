package com.qudopro.ch20;

import java.util.ArrayList;

public class Pila<T> {
    private final ArrayList<T> elementos;

    public Pila(){
        this(10);
    }

    public Pila(int capacity){
        int initCapacity = capacity > 0 ? capacity : 10;
        elementos = new ArrayList<>(initCapacity);
    }

    //Colocar elementos en la pila
    public void push(T element){
        elementos.add(element);
    }

    //Sacar el elemento mas alto de la pila
    public T pop(){
        if(elementos.isEmpty())
            throw new EmptyStackException("Stack is empty, cannot pop");

        return elementos.remove(elementos.size()-1);
    }
}

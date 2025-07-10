package com.qudopro.ch21;

public class StackInheritance<T> extends List<T> {
    public StackInheritance(){
        super("Stack");
    }

    //Add object to Stack
    public void push(T object){
        insertAtFront(object);
    }

    //Remove objeto from Stack
    public T pop(){
        return removeFromFront();
    }
}

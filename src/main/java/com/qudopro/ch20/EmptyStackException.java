package com.qudopro.ch20;

public class EmptyStackException extends RuntimeException{
    public EmptyStackException(){
        this("Stack is empty");
    }

    public EmptyStackException(String errorMessage){
        super(errorMessage);
    }
}

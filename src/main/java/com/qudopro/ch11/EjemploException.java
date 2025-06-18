package com.qudopro.ch11;

public class EjemploException extends Throwable{
    public EjemploException(){
        super("Error en metodo EjemploException");
    }
    public EjemploException(String exception){
        super(exception);
    }
    public EjemploException(String exception, Throwable t){
        super(exception, t);
    }
    public EjemploException(Throwable t){
        super(t);
    }
}

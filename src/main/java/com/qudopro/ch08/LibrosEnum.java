package com.qudopro.ch08;

public enum LibrosEnum {
    JHTP("Java How To Program", "2015"),
    PHTP("Python How To Program", "2018"),
    CHTP("C How To Program", "2013");

    private final String titulo;
    private final String ano;

    LibrosEnum(String titulo, String ano){
        this.titulo = titulo;
        this.ano = ano;
    }

    public String obtenerTitulo(){
        return titulo;
    }

    public String obtenerAno(){
        return ano;
    }
}

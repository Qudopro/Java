package com.qudopro.ch10;

public abstract class Empleado {
    private final String nombre;
    private final String apellido;
    private final String seguroSocial;


    public Empleado(String nombre, String apellido, String seguroSocial){
        this.nombre = nombre;
        this.apellido = apellido;
        this.seguroSocial = seguroSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSeguroSocial() {
        return seguroSocial;
    }

    @Override
    public String toString(){
        return String.format(
                "%s\s%s%n%s:\s%s",
                nombre, apellido, "Seguro social", seguroSocial
        );
    }

    public abstract double ingresos();
}

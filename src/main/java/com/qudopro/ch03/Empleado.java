package com.qudopro.ch03;

public class Empleado {
    private String nombre;
    private String apellidoPaterno;
    private double salarioMensual;

    public Empleado(String nombre, String apellidoPaterno, double salarioMensual){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;

        if(salarioMensual > 0.0)
            this.salarioMensual = salarioMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        if(salarioMensual > 0.0)
            this.salarioMensual = salarioMensual;
    }
}

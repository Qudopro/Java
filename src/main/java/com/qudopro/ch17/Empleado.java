package com.qudopro.ch17;

public class Empleado {
    private String nombre;
    private String apellido;
    private double salario;
    private String departamento;

    public Empleado(String nombre, String apellido, double salario, String departamento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-8s %8.2f %s", getNombre(), getApellido(), getSalario(), getDepartamento());
    }
}

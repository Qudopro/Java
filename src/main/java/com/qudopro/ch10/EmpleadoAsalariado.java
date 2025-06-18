package com.qudopro.ch10;

public class EmpleadoAsalariado extends Empleado{
    private double salarioSemanal;

    public EmpleadoAsalariado(String nombre, String apellido, String seguroSocial, double salarioSemanal){
        super(nombre, apellido, seguroSocial);

        if(salarioSemanal <= 0.0)
            throw new IllegalArgumentException("El salario del empleado debe ser mayor a cero");

        this.salarioSemanal = salarioSemanal;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        if(salarioSemanal <= 0.0)
            throw new IllegalArgumentException("El salario del empleado debe ser mayor a cero");

        this.salarioSemanal = salarioSemanal;
    }

    @Override
    public double ingresos() {
        return getSalarioSemanal();
    }

    @Override
    public String toString(){
        return String.format("Empleado Asalariado:%n%s%n%s:\t$%,.2f",
                super.toString(), "Salario semanal", getSalarioSemanal()
        );
    }

}

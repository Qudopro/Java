package com.qudopro.ch10;

import com.qudopro.ch10.EmpleadoPorComision;

public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    private double salarioBase;

    public EmpleadoBaseMasComision(String nombre, String apellido, String numeroSeguroSocial, double ventasBrutas, double tarifaComision, double salarioBase) {
        super(nombre, apellido, numeroSeguroSocial, ventasBrutas, tarifaComision);

        if (salarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser mayor a 0.0");

        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser mayor a 0.0");

        this.salarioBase = salarioBase;
    }

    @Override
    public double ingresos(){
        return salarioBase + super.ingresos();
    }

    @Override
    public String toString(){
        return String.format(super.toString() + "%n%s:\s%.2f", "Salario", salarioBase);
    }
}

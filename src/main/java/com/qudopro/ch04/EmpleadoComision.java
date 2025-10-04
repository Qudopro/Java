package com.qudopro.ch04;

public class EmpleadoComision {
    private String idEmpleado;
    private double salarioSemanal;
    private double comision;

    public EmpleadoComision(String idEmpleado, double salarioSemanal, double comision) {
        this.idEmpleado = idEmpleado;
        this.salarioSemanal = salarioSemanal;
        this.comision = comision;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        this.salarioSemanal = salarioSemanal;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double ingresos(double totalVentas){
        return salarioSemanal + totalVentas*comision;
    }
}

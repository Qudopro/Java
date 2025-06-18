package com.qudopro.ch09;

public class EmpleadoPorComision extends Object{
    private final String nombre;
    private final String apellido;
    private final String numeroSeguroSocial;

    private double ventasBrutas;
    private double tarifaComision;

    public EmpleadoPorComision(String nombre, String apellido, String numeroSeguroSocial, double ventasBrutas, double tarifaComision){
        //Llamada implícita al constructor de la clase Object

        if(ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas deben ser mayores o iguales a 0");

        if(tarifaComision <= 0.0 || tarifaComision > 1.0)
            throw new IllegalArgumentException("La tarifa de la comision no es valida");

        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroSeguroSocial = numeroSeguroSocial;
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public void setVentasBrutas(double ventasBrutas) {
        if(ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas deben ser mayores o iguales a 0");
        this.ventasBrutas = ventasBrutas;
    }

    public double getTarifaComision() {
        return tarifaComision;
    }

    public void setTarifaComision(double tarifaComision) {
        if(tarifaComision <= 0.0 || tarifaComision > 1.0)
            throw new IllegalArgumentException("La tarifa de la comision no es valida");
        this.tarifaComision = tarifaComision;
    }

    public double ingresos(){
        return ventasBrutas*tarifaComision;
    }

    @Override
    public String toString(){
        return String.format("%s\s%s%n%s:\s%s%n%s:\t%.2f%n%s:\t%.2f%n",
                nombre, apellido, "Seguro Social", numeroSeguroSocial, "Ventas Brutas", ventasBrutas, "Tarifa Comision", tarifaComision
        );
    }
}

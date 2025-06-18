package com.qudopro.ch10;

public class EmpleadoPorComision extends Empleado{
    private double ventasBrutas;
    private double tarifaComision;

    public EmpleadoPorComision(String nombre, String apellido, String numeroSeguroSocial, double ventasBrutas, double tarifaComision){
        super(nombre, apellido, numeroSeguroSocial);

        if(ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas deben ser mayores o iguales a 0");

        if(tarifaComision <= 0.0 || tarifaComision > 1.0)
            throw new IllegalArgumentException("La tarifa de la comision no es valida");

        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
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
    @Override
    public double ingresos() {
        return getTarifaComision() * getVentasBrutas();
    }

    @Override
    public String toString(){
        return String.format("Empleado por comision:%n%s%n%s:\t%.2f%n%s:\t%.2f",
            super.toString(), "Ventas brutas", getVentasBrutas(),"Tarifa por comision", getTarifaComision()
        );
    }
}

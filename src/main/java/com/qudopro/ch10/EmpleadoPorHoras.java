package com.qudopro.ch10;

public class EmpleadoPorHoras extends Empleado{
    private double sueldo;
    private double horas;

    public EmpleadoPorHoras(String nombre, String apellido, String seguroSocial, double sueldo, double horas){
        super(nombre, apellido, seguroSocial);

        if(sueldo <= 0.0)
            throw new IllegalArgumentException("El salario del empleado debe ser mayor a cero");

        if(horas < 0.0 || horas > 168.0)
            throw new IllegalArgumentException("El rango de horas a la semana trabajado no es valido");

        this.sueldo = sueldo;
        this.horas = horas;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if(sueldo <= 0.0)
            throw new IllegalArgumentException("El salario del empleado debe ser mayor a cero");
        this.sueldo = sueldo;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        if(horas < 0.0 || horas > 168.0)
            throw new IllegalArgumentException("El rango de horas a la semana trabajado no es valido");
        this.horas = horas;
    }

    @Override
    public double ingresos() {
        if(getHoras() <= 40)
            return getSueldo()*getHoras();
        else
            return (40*getSueldo())+((getHoras()-40)*(getSueldo()*1.5));
    }

    @Override
    public String toString(){
        return String.format("Empleado por horas:%n%s%n%s:\t$%,.2f%n%s:\s%.2f",
                super.toString(), "Sueldo", getSueldo(), "Horas trabajadas", horas
        );
    }
}

package com.qudopro.ch08;

public class PruebaEmpleado {
    public static void main(String[] args){
        Fecha fechaNacimiento = new Fecha(7,22, 1999);
        Fecha fechaContratacion = new Fecha(05,21, 2025);

        Empleado empleado = new Empleado("Diego", "Cabrera", fechaNacimiento, fechaContratacion);
        System.out.println(empleado);
        Empleado empleado2 = new Empleado("Sara", "Cabrera", fechaNacimiento, fechaContratacion);
        System.out.println(empleado2);

    }
}

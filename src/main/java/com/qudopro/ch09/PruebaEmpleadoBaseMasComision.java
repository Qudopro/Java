package com.qudopro.ch09;

public class PruebaEmpleadoBaseMasComision {
    public static void main(String[] args){
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision(
                "Diego", "Cabrera", "3151", 398, 0.1, 2500
        );

        System.out.println("Informacion del empleado base mas comision");
        System.out.println(empleadoBaseMasComision);
        System.out.printf("Ingresos: %.2f", empleadoBaseMasComision.ingresos());
    }
}

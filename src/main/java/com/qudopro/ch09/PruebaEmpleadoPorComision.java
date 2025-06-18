package com.qudopro.ch09;

public class PruebaEmpleadoPorComision {
    public static void main(String[] args){
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Diego", "Cabrera", "3151", 398, 0.1);

        System.out.println("Informacion del empleado por comision");
        System.out.println(empleadoPorComision);
        System.out.printf("Ingresos: %.2f", empleadoPorComision.ingresos());
    }

}

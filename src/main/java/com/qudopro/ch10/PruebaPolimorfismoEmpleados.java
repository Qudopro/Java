package com.qudopro.ch10;

public class PruebaPolimorfismoEmpleados {
    public static void main(String[] args){
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Diego", "Cabrera", "3151", 800.0);
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Luis", "Cabrera", "3152", 2000, 40);
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Mariana", "Cabrera", "3153", 10000,0.5);
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision("Reyna", "Cabrera", "3154", 5000, 0.2, 20000);

        System.out.println("Empleados procesados de forma no polimorfica");

        System.out.printf("%n%s%n%s:%,.2f%n", empleadoAsalariado, "Ingresos", empleadoAsalariado.ingresos());
        System.out.printf("%n%s%n%s:%,.2f%n", empleadoPorHoras, "Ingresos", empleadoPorHoras.ingresos());
        System.out.printf("%n%s%n%s:%,.2f%n", empleadoPorComision, "Ingresos", empleadoPorComision.ingresos());
        System.out.printf("%n%s%n%s:%,.2f%n", empleadoBaseMasComision, "Ingresos", empleadoBaseMasComision.ingresos());

        System.out.println("\nEmpleados procesados de forma polimorfica");
        Empleado[] empleado = new Empleado[4];
        empleado[0] = empleadoAsalariado;
        empleado[1] = empleadoPorHoras;
        empleado[2] = empleadoPorComision;
        empleado[3] = empleadoBaseMasComision;

        for(Empleado e : empleado){
            System.out.println(e);

            //Determina si el empleado es un empleado base más comisión
            if(e instanceof EmpleadoBaseMasComision){
                //Conversión descendente
                EmpleadoBaseMasComision empleadoBaseMasComision1 = (EmpleadoBaseMasComision) e;
                empleadoBaseMasComision1.setSalarioBase(1.10*empleadoBaseMasComision1.getSalarioBase());
                System.out.printf("Se ha incrementado el salario del empleado base mas comision en un 10 por ciento: %,.2f%n",
                        empleadoBaseMasComision1.getSalarioBase());
            }

            System.out.printf("%s:%,.2f%n%n", "Ingresos", e.ingresos());
        }

        System.out.println("Se obtendra el nombre del tipo de cada objeto en el arreglo polimorfico");
        for(int i = 0; i < empleado.length; i++){
            System.out.printf("El empleado %d es un:\t%s%n", i, empleado[i].getClass().getName());
        }
    }

}

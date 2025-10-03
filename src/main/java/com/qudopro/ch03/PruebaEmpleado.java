package com.qudopro.ch03;

public class PruebaEmpleado {
    public static void main(String[] args){
        Empleado empleado1 = new Empleado("Diego", "Cabrera", 2121.32);
        Empleado empleado2 = new Empleado("Daniel", "Gamboa", 43843);

        System.out.println("El empleado " + empleado1.getNombre() + " " + empleado1.getApellidoPaterno() + " tiene un salario anual de: " + empleado1.getSalarioMensual()*12);
        System.out.println("El empleado " + empleado2.getNombre() + " " + empleado2.getApellidoPaterno() + " tiene un salario anual de: " + empleado2.getSalarioMensual()*12);
    }
}

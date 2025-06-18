package com.qudopro.ch10;

import com.qudopro.ch09.EmpleadoBaseMasComision;
import com.qudopro.ch09.EmpleadoPorComision;

public class PruebaPolimorfismo {
    public static void main(String[] args){
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Diego", "Cabrera", "3151", 540,0.2);
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision("Luis", "Cabrera", "3152", 544,0.1, 1000);
        System.out.println("Informacion del empleado por comision");
        System.out.println(empleadoPorComision);
        System.out.println("Informacion del empleado base mas comision");
        System.out.println(empleadoBaseMasComision);

        //POLIMORFISMO
        EmpleadoPorComision empleadoPorComision1 = empleadoBaseMasComision;
        System.out.println("\nInformacion del empleado por comision con referencia a empleado base mas comision");
        System.out.println(empleadoPorComision1);
    }

}

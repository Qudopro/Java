package com.qudopro.ch05;

public class PruebaPolizaAutos {
    public static void main(String[] args){
        PolizaAutos poliza1 = new PolizaAutos(3151, "Chevy VW", "MX");
        PolizaAutos poliza2 = new PolizaAutos(4212, "Toyota Carmy", "YU");

        poliza(poliza1);
        poliza(poliza2);
    }

    public static void poliza(PolizaAutos poliza){
        System.out.printf("Cuenta: #%d%nAuto: %s%nEstado: %s%nSe encuentra en un estado sin culpa?: %s%n",
                poliza.getIdCuenta(), poliza.getMarcaModelo(), poliza.getEstado(), (poliza.isEstadoSinCulpa()? "Si":"No"));
    }
}

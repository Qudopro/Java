package com.qudopro.ch10;

public class PruebaInterfazPorPagar {
    public static void main(String[] args){
        PorPagar[] porPagar = new PorPagar[4];

        porPagar[0] = new Factura("01234", "Asiento", 43, 123.0);
        porPagar[1] = new Factura("01235", "Cama", 12, 345.0);
        porPagar[2] = new Factura("01236", "Escritorio", 87, 400.0);
        porPagar[3] = new Factura("01237", "Espejo", 123, 35.0);

        System.out.println("Procesamiento polimorfico");

        for(PorPagar p : porPagar)
            System.out.printf("%n%s%n%s\s$%,.2f", p, "Pago vencido", p.obtenerMontoPagar());
    }
}

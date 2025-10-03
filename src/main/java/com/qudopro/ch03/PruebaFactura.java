package com.qudopro.ch03;

public class PruebaFactura {
    public static void main(String[] args){
        Factura factura = new Factura("3232454", "Martillo marca patito", 23, 129.0);

        System.out.printf("%-40s%-20s%n", "Id del producto comprado:", factura.getNumeroPieza());
        System.out.printf("%-40s%-20s%n", "Descripcion del producto:", factura.getDescripcionPieza());
        System.out.printf("%-40s%-5d%n", "Cantidad comprada", factura.getCantidadArticulos());
        System.out.printf("%-40s$%,.2f%n", "Precio por articulo", factura.getPrecioPorArticulo());

        System.out.println("\nMonto total: " + factura.obtenerMontoFactura());
    }
}

//Clase para repreentar una factura para un articulo vendido de una Ferreteria
package com.qudopro.ch03;

public class Factura {
    private String numeroPieza;
    private String descripcionPieza;
    private int cantidadArticulos;
    private double precioPorArticulo;

    public Factura(String numeroPieza, String descripcionPieza, int cantidadArticulos, double precioPorArticulo){
        this.numeroPieza = numeroPieza;
        this.descripcionPieza = descripcionPieza;
        this.cantidadArticulos = cantidadArticulos;
        this.precioPorArticulo = precioPorArticulo;
    }

    public String getNumeroPieza() {
        return numeroPieza;
    }

    public void setNumeroPieza(String numeroPieza) {
        this.numeroPieza = numeroPieza;
    }

    public String getDescripcionPieza() {
        return descripcionPieza;
    }

    public void setDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(int cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }

    public double getPrecioPorArticulo() {
        return precioPorArticulo;
    }

    public void setPrecioPorArticulo(double precioPorArticulo) {
        this.precioPorArticulo = precioPorArticulo;
    }

    public double obtenerMontoFactura(){
        double monto = this.cantidadArticulos * this.precioPorArticulo;

        if(monto < 0.0)
            return 0.0;
        else
            return monto;
    }
}

package com.qudopro.ch10;

public class Factura implements PorPagar{
    private final String numeroPieza;
    private final String descripcion;
    private int cantidad;
    private double precioPorArticulo;

    public Factura(String numeroPieza, String descripcion, int cantidad, double precioPorArticulo){
        if(cantidad < 0)
            throw new IllegalArgumentException("Cantidad por articulo no valido");

        if(precioPorArticulo < 0.0)
            throw new IllegalArgumentException("Precio por articulo no valido");

        this.cantidad = cantidad;
        this.numeroPieza = numeroPieza;
        this.descripcion = descripcion;
        this.precioPorArticulo = precioPorArticulo;
    }

    public String getNumeroPieza() {
        return numeroPieza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if(cantidad < 0)
            throw new IllegalArgumentException("Cantidad por articulo no valido");

        this.cantidad = cantidad;
    }

    public double getPrecioPorArticulo() {
        return precioPorArticulo;
    }

    public void setPrecioPorArticulo(double precioPorArticulo) {
        if(precioPorArticulo < 0.0)
            throw new IllegalArgumentException("Precio por articulo no valido");

        this.precioPorArticulo = precioPorArticulo;
    }

    @Override
    public String toString(){
        return String.format("%s:%n%s:\s%s\s(%s)%n%s:\s%d%n",
                "Factura", "Numero de piezas", getNumeroPieza(), getDescripcion(), "Cantidad", getCantidad(), "Precio por articulo", getPrecioPorArticulo()
                );
    }

    @Override
    public double obtenerMontoPagar() {
        return getCantidad() * getPrecioPorArticulo();
    }
}

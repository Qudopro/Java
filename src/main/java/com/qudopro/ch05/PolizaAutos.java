package com.qudopro.ch05;

public class PolizaAutos {
    private int idCuenta;
    private String marcaModelo;
    private String estado;

    public PolizaAutos(int idCuenta, String marcaModelo, String estado){
        this.idCuenta = idCuenta;
        this.marcaModelo = marcaModelo;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    //Método predicado
    public boolean isEstadoSinCulpa(){
        boolean estadoSinCulpa;

        switch(getEstado()){
            case "SO":
            case "CH":
            case "MX":
            case "JA":
                estadoSinCulpa = true;
                break;
            default:
                estadoSinCulpa = false;
                break;
        }

        return estadoSinCulpa;
    }
}

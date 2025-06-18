package com.qudopro.ch15;

import java.io.Serializable;

public class CuentaSerializable implements Serializable {

    private int cuenta;
    private String nombre;
    private String apellido;
    private double saldo;

    public CuentaSerializable(){
        this(0, "", "", 0.0);
    }

    public CuentaSerializable(int cuenta, String nombre, String apellido, double saldo){
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

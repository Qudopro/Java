package com.qudopro.ch03;

public class Cuenta {
    private String nombre;
    private double saldo;

    public Cuenta(){}

    public Cuenta(String nombre){
        this.nombre = nombre;
    }

    public Cuenta(String nombre, double saldo){
        this.nombre = nombre;
        if(saldo > 0.0) {
            this.saldo = saldo;
        }
    }


    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void depositar(double saldo){
        if(saldo > 0.0){
            this.saldo = this.saldo + saldo;
        }
    }

    public double obtenerSaldo() {
        return saldo;
    }

    public void retirar(double monto){
        if (monto > saldo){
            System.out.println("El monto a retirar excede el saldo de la cuenta");
        }else {
            saldo = saldo - monto;
        }
    }

}

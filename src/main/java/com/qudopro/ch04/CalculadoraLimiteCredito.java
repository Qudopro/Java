package com.qudopro.ch04;

public class CalculadoraLimiteCredito {
    private String numeroCuenta;
    private int saldoInicioMes;
    private int totalArticulosMes;
    private int totalCreditosAplicadosMes;
    private int limiteCredito;

    public CalculadoraLimiteCredito(String numeroCuenta, int saldoInicioMes, int totalArticulosMes, int totalCreditosAplicadosMes, int limiteCredito) {
        this.numeroCuenta = numeroCuenta;
        this.saldoInicioMes = saldoInicioMes;
        this.totalArticulosMes = totalArticulosMes;
        this.totalCreditosAplicadosMes = totalCreditosAplicadosMes;
        this.limiteCredito = limiteCredito;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldoInicioMes() {
        return saldoInicioMes;
    }

    public void setSaldoInicioMes(int saldoInicioMes) {
        this.saldoInicioMes = saldoInicioMes;
    }

    public int getTotalArticulosMes() {
        return totalArticulosMes;
    }

    public void setTotalArticulosMes(int totalArticulosMes) {
        this.totalArticulosMes = totalArticulosMes;
    }

    public int getTotalCreditosAplicadosMes() {
        return totalCreditosAplicadosMes;
    }

    public void setTotalCreditosAplicadosMes(int totalCreditosAplicadosMes) {
        this.totalCreditosAplicadosMes = totalCreditosAplicadosMes;
    }

    public int getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public int nuevoSaldo(){
        return getSaldoInicioMes() + getTotalArticulosMes() - getTotalCreditosAplicadosMes();
    }

    public boolean isExceed(int saldo){
        return getLimiteCredito() < saldo;
    }
}

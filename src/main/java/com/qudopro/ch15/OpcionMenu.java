package com.qudopro.ch15;

public enum OpcionMenu {
    SALDO_CERO(1),
    SALDO_CREDITO(2),
    SALDO_DEBITO(3),
    FIN(4);

    private int valor;

    private OpcionMenu(int valor){
        this.valor = valor;
    }
}

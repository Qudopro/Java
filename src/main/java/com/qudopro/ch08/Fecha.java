package com.qudopro.ch08;

public class Fecha {
    private int mes;
    private int dia;
    private int ano;

    private static final int[] diasPorMes = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Constructor que confirma el valor apropiado para dia, mes  y ano
     * @param mes
     * @param dia
     * @param ano
     */
    public Fecha(int mes, int dia, int ano){
        if(mes <= 0 && mes > 12)
            throw new IllegalArgumentException("Valor de mes no valido");

        if(dia <= 0 || dia > diasPorMes[mes]  && !(mes == 2 && dia == 29))
            throw new IllegalArgumentException("Valor de dia no valido");

        //Revisa si es año bisiesto
        if(mes == 2 && dia == 29 && ! (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)))
            throw new IllegalArgumentException("Valor de dia no valido");

        this.ano = ano;
        this.mes = mes;
        this.dia = dia;

        System.out.printf("Constructor de objeto Fecha %s%n", this);
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString(){
        return String.format("%d/%d/%d", dia, mes, ano);
    }
}
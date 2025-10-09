package com.qudopro.ch06;

public class Estacionamiento {
    private double cuotaMinima = 2.0;
    private double cuotaAdicional = 0.5;
    private double cuotaMaxima = 10.0;

    private int horas;
    private double cuota;


    public Estacionamiento(int horas){
        if(horas >= 0 && horas <= 24)
            this.horas = horas;
    }

    public double getCuotaMinima(){
        return cuotaMinima;
    }

    public double getCuotaAdicional(){
        return cuotaAdicional;
    }

    public double getCuotaMaxima(){
        return cuotaMaxima;
    }

    public void setCuota(double cuota){
        this.cuota = cuota;
    }

    public int getHoras(){
        return horas;
    }

    public void setHoras(int horas){
        this.horas = horas;
    }

    public double calcularCargos(){
        double monto = 0.0;
        int horasExtra = 0;
        if(getHoras() <= 3){
            monto = cuotaMinima;
        }else if(getHoras() <= 24){
            horasExtra = getHoras()-3;

            monto = cuotaMinima+(horasExtra*cuotaAdicional);
        }

        if(isNotMaximum(monto))
            return monto;
        else
            return cuotaMaxima;
    }

    private boolean isNotMaximum(double monto){
        return monto <= getCuotaMaxima();
    }
}
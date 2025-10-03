package com.qudopro.ch03;

public class FrecuenciasCardiacas {
    private String primerNombre;
    private String apellidoPaterno;
    private int day;
    private int month;
    private int year;

    public FrecuenciasCardiacas(String primeNombre, String apellidoPaterno, int day, int month, int year){
        this.primerNombre = primeNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int age(){
        return 2025-year;
    }

    public int frecuenciaCardiacaMaxima(){
        return 220 - this.age();
    }

    public int frecuenciaCardiacaMaximaEsperada(){
        return (int)(frecuenciaCardiacaMaxima() * 0.85);
    }
    public int frecuenciaCardiacaMinimaEsperada(){
        return (int)(frecuenciaCardiacaMaxima() * 0.5);
    }
}

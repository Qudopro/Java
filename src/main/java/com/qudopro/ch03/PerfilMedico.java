package com.qudopro.ch03;

public class PerfilMedico {
    private String primerNombre;
    private String apellidoPaterno;
    private String sexo;
    private int day;
    private int month;
    private int year;
    private int alturaCm;
    private int pesoKg;

    private static int nowYear = 2025;

    public PerfilMedico(String primerNombre, String apellidoPaterno, String sexo, int day, int month, int year, int alturaCm, int pesoKg) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.sexo = sexo;
        this.day = day;
        this.month = month;
        this.year = year;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public int getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(int alturaCm) {
        this.alturaCm = alturaCm;
    }

    public int getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(int pesoKg) {
        this.pesoKg = pesoKg;
    }

    public int getAge(){
        return nowYear - year;
    }

    public int frecuenciaCardiacaMaxima(){
        return 220 - this.getAge();
    }

    public int frecuenciaCardiacaMaximaEsperada(){
        return (int)(frecuenciaCardiacaMaxima() * 0.85);
    }
    public int frecuenciaCardiacaMinimaEsperada(){
        return (int)(frecuenciaCardiacaMaxima() * 0.5);
    }

    public double getBMI(){
        return pesoKg/((getAlturaCm()/100.0)*(getAlturaCm()/100.0));
    }

}

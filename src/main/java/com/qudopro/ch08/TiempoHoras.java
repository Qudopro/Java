package com.qudopro.ch08;

public class TiempoHoras {
    private int hora;
    private int minutos;
    private int segundos;

    public TiempoHoras(){
        this(0,0,0);
    }

    public TiempoHoras(int horas){
        this(horas,0,0);
    }

    public TiempoHoras(int horas, int minutos){
        this(horas, minutos,0);
    }

    public TiempoHoras(int horas, int minutos, int segundos){
        this.establecerTiempoHoras(horas, minutos, segundos);
    }

    public TiempoHoras(TiempoHoras tiempoHoras){
        this(tiempoHoras.obtenerHora(), tiempoHoras.obtenerMinutos(), tiempoHoras.obtenerSegundos());
    }

    public void establecerTiempoHoras(int hora, int minutos, int segundo){
        establecerHora(hora);
        establecerMinutos(minutos);
        establecerSegundos(segundo);
    }

    public int obtenerHora() {
        return hora;
    }

    public void establecerHora(int hora) {
        if(hora < 0 || hora > 23)
            throw new IllegalArgumentException("Valor de hora fuera de rango");
        this.hora = hora;
    }

    public int obtenerMinutos() {
        return minutos;
    }

    public void establecerMinutos(int minutos) {
        if(minutos < 0 || minutos > 59)
            throw new IllegalArgumentException("Valor de minutos fuera de rango");
        this.minutos = minutos;
    }

    public int obtenerSegundos() {
        return segundos;
    }

    public void establecerSegundos(int segundos) {
        if(segundos < 0 || segundos > 59)
            throw new IllegalArgumentException("Valor de segundos fuera de rango");
        this.segundos = segundos;
    }

    //Genera un objeto String en formato de hora universal
    public String horaUniversal(){
        return String.format("%02d:%02d:%02d",
                hora, minutos, segundos
        );
    }
    //Genera un objeto String en formato de hora 24 horas
    @Override
    public String toString(){
        return String.format("%d:%02d:%02d\s%s",
                (hora == 0 || hora == 12 ? 12 : hora % 12), minutos, segundos,
                (hora < 12 ? "AM": "PM")
        );
    }

}

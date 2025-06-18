package com.qudopro.ch08;

public class ThisTwoClasses {
    public static void main(String[] args){
        TiempoHorasSimple tiempoHorasSimple = new TiempoHorasSimple(15,30,45);
        System.out.println(tiempoHorasSimple);
    }
}

class TiempoHorasSimple{
    private int hora;
    private int minutos;
    private int segundos;

    public TiempoHorasSimple(){
        this(0,0,0);
    }

    public TiempoHorasSimple(int hora, int minutos, int segundos){
        if(hora < 0 || hora > 23 || minutos < 0 || minutos > 59 || segundos < 0 || segundos > 59)
            throw new IllegalArgumentException("Error. Hora, minuto o segundo fuera del rango valido");

        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    //Genera un objeto String en formato de hora universal
    public String horaUniversal(){
        return String.format("%02d:%02d:%02d",
                this.hora, this.minutos, this.segundos
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

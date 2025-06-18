package com.qudopro.ch08;

public class ModificadorPackage {
    public static void main(String[] args){
        DatosPaquete datosPaquete = new DatosPaquete();

        System.out.printf("Despues de inicializar:%n%s%n", datosPaquete);

        datosPaquete.numero = 77;
        datosPaquete.cadena = "Hola";
        System.out.printf("Despues de modificar los campos:%n%s%n", datosPaquete);
    }
}

class DatosPaquete{
    int numero;
    String cadena;
    private String nombre;

    public DatosPaquete(){
        numero = 0;
        cadena = "Escribe algo";
        nombre = "Diego";
    }

    @Override
    public String toString() {
        return "DatosPaquete{" +
                "numero=" + numero +
                ", cadena='" + cadena + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

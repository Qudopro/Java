package com.qudopro.ch16;

import java.util.*;

public class MapTest {
    public static void main(String[] args){
        //Crea un Map con implementación HashMap. Registro de cuantas veces aparece una palabra en una oracion
        Map<String, Integer> objetoMap = new HashMap<>();

        crearMap(objetoMap);
        imprimirMap(objetoMap);
    }

    //Crea un objeto Map
    private static void crearMap(Map<String, Integer> map){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escriba una oracion: ");
        String cadena = entrada.nextLine();

        //Divide la entrada en tokens
        String[] tokens = cadena.split(" ");
        for(String s : tokens){
            String palabra = s.toLowerCase();

            //Determina si el mapa contiene la palabra
            if(map.containsKey(palabra)){
                int cuenta = map.get(palabra);
                map.put(palabra, cuenta+1);
            }else
                map.put(palabra, 1);
        }
    }

    private static void imprimirMap(Map<String, Integer> map){
        Set<String> clave = map.keySet();           //Obtiene las claves del objeto map

        TreeSet<String> ordenKey = new TreeSet<>(clave);
        System.out.printf("%nEl mapa contiene: %n\t\tClave\t\tValor%n");

        for(String s : ordenKey)
            System.out.printf("%-10s%10s%n", s, map.get(s));

        System.out.printf("%nSize: %d%nisEmpty: %b%n",map.size(), map.isEmpty());
    }
}

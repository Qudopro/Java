package com.qudopro.ch16;

import com.qudopro.ch08.TiempoHoras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonalizedSort {
    public static void main(String[] args){
        List<TiempoHoras> lista = new ArrayList<>();
        lista.add(new TiempoHoras(23,43,43));
        lista.add(new TiempoHoras(19,32,32));
        lista.add(new TiempoHoras(23,7,26));
        lista.add(new TiempoHoras(5,59,7));
        lista.add(new TiempoHoras(5,2,56));

        System.out.println("Elementos de la lista: " + lista);


        Collections.sort(lista, new ComparatorTiempoHoras());
        System.out.println("Elementos de la lista: " + lista);
    }

}

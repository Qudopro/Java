package com.qudopro.ch16;

import com.qudopro.ch08.TiempoHoras;
import java.util.Comparator;

public class ComparatorTiempoHoras implements Comparator<TiempoHoras> {
    /**
     * Compare two objects
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return positive number if o1 is greater than o2, negative number if o1 is less than o2, 0 if o1 is equal to o2
     */
    @Override
    public int compare(TiempoHoras o1, TiempoHoras o2) {
        int diferenciaHora = o1.obtenerHora()-o2.obtenerHora();
        if(diferenciaHora != 0)
            return diferenciaHora;

        int diferenciaMinuto = o1.obtenerMinutos() - o2.obtenerMinutos();
        if(diferenciaMinuto != 0)
            return diferenciaMinuto;

        int diferenciaSegundos = o1.obtenerSegundos() - o2.obtenerSegundos();
        if(diferenciaSegundos != 0)
            return diferenciaSegundos;

        return 0;
    }
}

package com.qudopro.ch06;

import java.util.ArrayList;
import java.util.List;

public class MaximoComunDivisor {
    public static void main(String[] args){
        System.out.printf("El maximo comun divisor entre %d y %d es: %d%n", 12, 16, maximoComunDivisor(12,16));
    }

    public static int maximoComunDivisor(int numero1, int numero2){
        List<Integer> maximumList1 = new ArrayList<>();
        List<Integer> maximumList2 = new ArrayList<>();
        List<Integer> maximumList3 = new ArrayList<>();

        int maximum = 0;

        for(int i = 1; i <= numero1; i++){
            if(numero1%i == 0)
                maximumList1.add(i);
        }

        for(int i = 1; i <= numero2; i++){
            if(numero2%i == 0)
                maximumList2.add(i);
        }


        for(int i = 0; i < maximumList1.size(); i++){
            if(maximumList2.contains(maximumList1.get(i))){
                maximumList3.add(maximumList1.get(i));
            }
        }

        maximum = maximumList3.get(maximumList3.size()-1);

        return maximum;
    }

}

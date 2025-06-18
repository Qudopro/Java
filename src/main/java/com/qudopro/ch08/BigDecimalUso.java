package com.qudopro.ch08;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class BigDecimalUso {
    public static void main(String[] args){
        //Monto inicial antes del calculo del interes
        BigDecimal principal = BigDecimal.valueOf(1000.0);
        BigDecimal tasa = BigDecimal.valueOf(0.05);
        BigDecimal ejemplo = BigDecimal.valueOf(29121.4690121);
        System.out.printf("%s%20s%n", "Anio", "Monto en deposito");
        for(int i = 1; i <= 10; i++){
            BigDecimal monto = principal.multiply(tasa.add(BigDecimal.ONE).pow(i));

            System.out.printf("%4d%20s%n", i,
                    NumberFormat.getCurrencyInstance().format(monto)
                    );
        }

        System.out.println(ejemplo.setScale(2, RoundingMode.HALF_EVEN));
    }
}

package com.qudopro.ch05;

public class ValorPI {
    public static void main(String[] args){
        double result = 0;
        int n = 1;

        System.out.printf("%20s%20s%n","Serie", "Valor de PI");
        for(int i = 0; i < n; i++, n++){
            int value =  i*2+1;

            if(i % 2 == 0) {
                result = result + 4.0/value;
            }else {
                result = result - 4.0/value;
            }

            System.out.printf("%-,20d%,.14f%n", i+1, result);

            /*
            if(Double.parseDouble(String.format("%.5f", result)) == 3.14159)
                break;
            */
            if(n == 200000)
                break;
        }

//        System.out.println("Numero de n (ciclos) donde el valor es 3.14159 es: " + n);
    }
}

/*
"""Approximating the Mathematical Constant Pi"""
n = 1
while True:
    result = 0
    print("Numero de ciclos: ", n)
    for number in range(0,n):
        value = number*2+1
        if(number % 2 == 0):
            result = result + 4/value
        else:
            result = result - 4/value
    print(result)
    if round(result, 4) == 3.1415:
        break;
    print()
    n += 1

 */
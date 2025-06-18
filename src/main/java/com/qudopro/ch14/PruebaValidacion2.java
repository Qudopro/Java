package com.qudopro.ch14;

public class PruebaValidacion2 {
    public static void main(String[] args){
        String vocales = "a";
        String mayusculas = "F";
        String letraExcluida = "Z";
        String mayusculasMinusculas = "g";
        System.out.println("Validacion: " + vocales.matches("[aeiou]"));                //Cualquier caracter definido
        System.out.println("Validacion: " + mayusculas.matches("[A-Z]"));               //Cualquier letra mayúsculas
        System.out.println("Validacion: " + letraExcluida.matches("[^Z]"));               //Cualquier letra menos la Z
        System.out.println("Validacion: " + mayusculasMinusculas.matches("[a-zA-Z]"));  //Cualquier letra mayuscula y minuscula



        String vocales2 = "aei";
        String mayusculas2 = "FGFD";
        String letraExcluida2 = "Z";
        String mayusculasMinusculas2 = "gfsaFFFC";
        String digito1 = "32";
        String digito2 = "3232";
        String digito3 = "49344343";

        System.out.println("Validacion: " + vocales2.matches("[aeiou]*"));                //Cualquier caracter definido CERO O MÁS VECES
        System.out.println("Validacion: " + mayusculas2.matches("[A-Z]+"));               //Cualquier letra mayúsculas UNA O MAS VECES
        System.out.println("Validacion: " + letraExcluida2.matches("[^Z]?"));             //Cualquier letra menos la Z CERO O UNA VEZ
        System.out.println("Validacion: " + mayusculasMinusculas2.matches("[a-zA-Z]*"));   //Cualquier letra mayuscula y minuscula CERO MAS VECES
        System.out.println("Validacion: " + digito1.matches("\\d{2}"));                     //Dos digitos
        System.out.println("Validacion: " + digito2.matches("\\d{4,}"));                    //Con al menos 4 digitos
        System.out.println("Validacion: " + digito3.matches("\\d{4,9}"));                   //Entre 4 y 9 digitos


    }
}

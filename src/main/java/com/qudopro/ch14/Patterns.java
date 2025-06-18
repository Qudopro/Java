package com.qudopro.ch14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {
    public static void main(String[] args){
        Pattern pattern = Pattern.compile("J[(\\w)*\\s+]*\\d\\d-\\d\\d-\\d\\d");
        String cadena = "Jane nacio el 25-05-29\nDave nacio el 11-09-68\nJohn nacio el 04-28-73";

        Matcher matchers = pattern.matcher(cadena);

        while(matchers.find()){
            System.out.println(matchers.group());
        }
    }

}

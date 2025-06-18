package com.qudopro.ch14;

public class StringBuilderAppend {
    public static void main(String[] args){
        Object object = "Hola";
        String cadena = "Adios";
        char[] arregloChar = {'a','e','i','o','u'};
        boolean booleanValue = true;
        char charValue = 'Z';
        int intValue = 92;
        long longValue = 1000L;
        float floatValue = 2.54F;
        double doubleValue = 393.232;
        StringBuilder builderObject = new StringBuilder("Last Builder");
        StringBuilder builder = new StringBuilder();

        builder.append(object)
                .append("\n")
                .append(cadena)
                .append("\n")
                .append(arregloChar)
                .append("\n")
                .append(booleanValue)
                .append("\n")
                .append(charValue)
                .append("\n")
                .append(intValue)
                .append("\n")
                .append(longValue)
                .append("\n")
                .append(floatValue)
                .append("\n")
                .append(doubleValue)
                .append("\n")
                .append(builderObject);

        System.out.println(builder);

        String s = new StringBuilder().append("Hola").append(" y adios").toString();
        System.out.println(s);
    }
}

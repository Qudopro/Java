package com.qudopro.ch14;

public class StringBuilderInsertDelete {
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
        StringBuilder builder = new StringBuilder();


        builder.insert(0, object);
        builder.insert(0, " ");
        builder.insert(0, cadena);
        builder.insert(0, " ");
        builder.insert(0, arregloChar);
        builder.insert(0, " ");
        builder.insert(0, booleanValue);
        builder.insert(0, " ");
        builder.insert(0, charValue);
        builder.insert(0, " ");
        builder.insert(0, intValue);
        builder.insert(0, " ");
        builder.insert(0, longValue);
        builder.insert(0, " ");
        builder.insert(0, floatValue);
        builder.insert(0, " ");
        builder.insert(0, charValue);
        builder.insert(0, " ");
        builder.insert(0, doubleValue);
        builder.insert(0, " ");

        System.out.println(builder);

        builder.deleteCharAt(10);
        System.out.println(builder);
        builder.delete(2, 6);
        System.out.println(builder);
    }
}

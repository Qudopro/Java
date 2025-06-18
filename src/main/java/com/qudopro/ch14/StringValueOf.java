package com.qudopro.ch14;

public class StringValueOf {
    public static void main(String[] args){
        char[] charArray = {'a', 'e', 'i', 'o', 'u'};
        boolean valorBoolean = true;
        char charValue = 'z';
        int intValue = 8;
        long longValue = 100000000L;
        float floatValue = 94.43F;
        Object objectValue = "Hola";
        double doubleValue = 39393.232;

        System.out.println(String.valueOf(charArray));
        System.out.println(String.valueOf(charArray, 1, 3));
        System.out.println(String.valueOf(valorBoolean));
        System.out.println(String.valueOf(charValue));
        System.out.println(String.valueOf(intValue));
        System.out.println(String.valueOf(longValue));
        System.out.println(String.valueOf(floatValue));
        System.out.println(String.valueOf(objectValue));
        System.out.println(String.valueOf(doubleValue));
    }
}

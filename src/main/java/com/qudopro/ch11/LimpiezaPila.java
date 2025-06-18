package com.qudopro.ch11;

public class LimpiezaPila {
    public static void main(String[] args){
        System.out.println("Se ejecuta el metodo Main");
        try{
            metodo1();
        }catch(Exception e) {
            System.err.println("Se ejecuta el catch del metodo Main");
            e.printStackTrace();

            //Obtiene la información del rastreo de la pila
            StackTraceElement[] elements = e.getStackTrace();
            System.out.println("Clase\t\t\t\t\t\t\tArchivo\t\t\tLinea\tMetodo");
            for (StackTraceElement s : elements) {
                System.out.printf("%s\t%s\t%s\t%s\t", s.getClassName(), s.getFileName(), s.getLineNumber(), s.getMethodName());
                System.out.println();
            }
        }
    }

    public static void metodo1() throws Exception{
        System.out.println("Se ejecuta metodo1");

        metodo2();
    }

    public static void metodo2() throws Exception{
        System.out.println("Se ejecuta metodo2");
        metodo3();
    }

    public static void metodo3() throws Exception{
        System.out.println("Se ejecuta metodo3");
        throw new Exception("Se lanza excepcion desde metodo3");
    }
}

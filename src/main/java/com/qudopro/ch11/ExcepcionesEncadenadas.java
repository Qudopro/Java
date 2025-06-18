package com.qudopro.ch11;

public class ExcepcionesEncadenadas {
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
        try{
            metodo2();
        }catch(Exception e){
            throw new Exception("Excepcion metodo1", e);
        }
    }

    public static void metodo2() throws Exception{
        System.out.println("Se ejecuta metodo2");
        try{
            metodo3();
        }catch(Exception e){
            throw new Exception("Excepcion metodo2", e);
        }
    }

    public static void metodo3() throws Exception{
        System.out.println("Se ejecuta metodo3");
        throw new Exception("Se lanza excepcion desde metodo3");
    }
}

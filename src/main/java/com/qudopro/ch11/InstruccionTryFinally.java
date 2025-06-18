package com.qudopro.ch11;

public class InstruccionTryFinally {
    public static void main(String[] args){
        try{
            lanzarException();
        }catch(Exception e){
            System.err.println("La excepcion se maneja en main");
        }

        noLanzarException();
    }

    public static void lanzarException() throws Exception{
        try{
            System.out.println("Metodo lanzarException");
            throw new Exception("Error generado en lanzarException");
        }catch(Exception e){
            System.err.println("Catch de lanzarException");
            throw e;            //Vuelve a lanzar la excepcion
        }finally{
            System.out.println("Bloque finally del metodo lanzarException");
        }
    }

    public static void noLanzarException(){
        try{
            System.out.println("Metodo noLanzarException");
        }catch(Exception e){
            System.err.println("Catch de noLanzarException");
        }finally{
            System.out.println("Bloque finally del metodo noLanzarException");
        }

        System.out.println("Fin de noLanzarException");
    }

}

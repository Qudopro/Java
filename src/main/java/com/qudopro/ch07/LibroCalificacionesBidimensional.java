package com.qudopro.ch07;

public class LibroCalificacionesBidimensional {
    private String nombreCurso;
    private int[][] calificaciones;

    public LibroCalificacionesBidimensional(String nombreCurso, int[][] calificaciones) {
        this.nombreCurso = nombreCurso;
        this.calificaciones = calificaciones;
    }

    public String obtenerNombreCurso() {
        return nombreCurso;
    }

    public void establecerNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int[][] obtenerCalificaciones() {
        return calificaciones;
    }

    public void establecerCalificaciones(int[][] calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void procesarCalificaciones(){
        //Imprimir el arreglo en pantalla
        imprimirCalificaciones();
        //Obtiene el valor minimo y maximo ingresado
        System.out.printf("La calificacion mas baja y alta es: %d y %d%n", obtenerMinimo(), obtenerMaximo());
        //Imprime el grafico de barras de la distribucion de calificaciones
        imprimirGrafico();
    }


    public int obtenerMinimo(){
        int minimo = calificaciones[0][0];

        for(int[] i : calificaciones){
            for(int j : i){
                if(minimo > j)
                    minimo = j;
            }
        }

        return minimo;
    }

    public int obtenerMaximo(){
        int maximo = calificaciones[0][0];

        for(int[] i : calificaciones){
            for(int j : i){
                if(maximo < j)
                    maximo = j;
            }
        }
        return maximo;
    }

    public double obtenerPromedio(int[] conjuntoCalificaciones){
        int total = 0;

        for(int i : conjuntoCalificaciones)
            total += i;

        return (double)total/conjuntoCalificaciones.length;
    }

    public void imprimirCalificaciones(){
        System.out.println("Se muestran las calificaciones de la clase");
        for(int i = 0; i < calificaciones.length; i++){
            System.out.printf("Calificaciones para el estudiante %2d%n", i+1);
            for(int j : calificaciones[i]){
                System.out.printf("%d\t", j);
            }

            double promedio = obtenerPromedio(calificaciones[i]);
            System.out.printf("El promedio del estudiante fue:\t%.2f%n", promedio);
        }
    }

    public void imprimirGrafico(){
        System.out.println("Distribucion de calificaciones");

        //Almacena la frecuencia de las calificaciones en cada rango de 10 calificaciones
        int[] frecuencia = new int[11];

        //Para cada calificación, incrementa la frecuencia adecuada
        for(int[] i : calificaciones){
            for(int j : i){
                ++frecuencia[j/10];
            }
        }

        //Para cada frecuencia, imprime una barra en el gráfico
        for(int i = 0; i < frecuencia.length; i++){
            //Imprime las etiquetas de la barra
            if(i == 10)
                System.out.printf("%5d:\t", 100);
            else
                System.out.printf("%02d-%02d:\t", i*10, i*10+9);

            for(int j = 0; j < frecuencia[i]; j++)
                System.out.print("*");

            System.out.println();
        }
    }
}

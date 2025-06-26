package com.qudopro.ch17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcesarEmpleado {
    public static void main(String[] args){
        Empleado[] empleados = {
                new Empleado("Diego", "Cabrera", 32.32, "TI"),
                new Empleado("Diego", "Sanchez", 38.32, "Ventas")
        };

        List<Empleado> listEmpleado = Arrays.asList(empleados);

        System.out.println("Lista de empleados");
        listEmpleado.stream().forEach(System.out::println);

        //Filtro
        Predicate<Empleado> greatherThirtyFive =
                x -> (x.getSalario() >= 35.00 && x.getSalario() <= 40);

        //Ordenamiento ascendente
        System.out.println("\nEmpleados que ganen mas de 35.00");
        listEmpleado.stream()
                .filter(greatherThirtyFive)
                .sorted(Comparator.comparing(Empleado::getSalario))
                .forEach(System.out::println);

        //Encontrar primer elemento
        System.out.println("\nEncontrar el primer empleado que gane mas de 35.00: \n" +
            listEmpleado.stream()
                    .filter(greatherThirtyFive)
                    .findFirst()
                    .get());

        //Comparaciones
        Function<Empleado, String> porNombre =
                Empleado::getNombre;
        Function<Empleado, String> porApellido =
                Empleado::getApellido;

        Comparator<Empleado> apellidoLuegoNombre =
                Comparator.comparing(porApellido).thenComparing(porNombre);

        System.out.println("\nComparacion por apellido luego por nombre: \n");
        listEmpleado.stream()
                .sorted(apellidoLuegoNombre)
                .forEach(System.out::println);

        System.out.println("\nComparacion por apellido luego por nombre descendente: \n");
        listEmpleado.stream()
                .sorted(apellidoLuegoNombre.reversed())
                .forEach(System.out::println);

        //Muestra apellidos de empleados unicos y ordenados
        System.out.println("\nApellidos unicos\n");
        listEmpleado.stream()
                .map(Empleado::getApellido)             //Obtiene solo los apellidos del flujo
                .distinct()
                .sorted()
                .forEach(System.out::println);

        //Muestra solo nombre y apellido
        System.out.println("\nNombres de los empleados y ordenados\n");
        listEmpleado.stream()
                .sorted(apellidoLuegoNombre)
                .map(Empleado::getNombre)               //Obtiene los nombres del flujo
                .forEach(System.out::println);

        //Agrupamientos
        System.out.println("\nEmpleados por departamento\n");
        Map<String, List<Empleado>> agrupamiento =
                listEmpleado.stream()
                        .collect(Collectors.groupingBy(Empleado::getDepartamento));
        //Recorriendo objeto Map con flujos
        agrupamiento.forEach(
                (departamento, listEmpleados) ->{
                    System.out.println("Departamento: " + departamento);
                    listEmpleados.stream()
                            .forEach(
                                    System.out::println
                            );
                }
        );

        //Numero de Empleados que coincidan con un agrupamiento
        System.out.println("\nNumero de empleados por departamento\n");
        Map<String, Long> conteoEmpleados =
                listEmpleado.stream()
                        .collect(Collectors.groupingBy(
                           Empleado::getDepartamento, Collectors.counting()
                        ));

        conteoEmpleados.forEach(
                (departamento, cuenta) -> {
                    System.out.printf("El departamento %s tiene %d empleado(s)%n",
                            departamento, cuenta
                            );
                }
        );

        //Manipulacion DoubleStream
        System.out.printf("%nSuma de salarios: %.2f%n",
                    listEmpleado.stream()
                            .mapToDouble(Empleado::getSalario)
                            .sum()
                );

        System.out.printf("%nSuma de salarios con reduce: %.2f%n",
                    listEmpleado.stream()
                            .mapToDouble(Empleado::getSalario)
                            .reduce(0, (x,y)->x+y));

        System.out.printf("%nPromedio de los salarios: %.2f%n",
                    listEmpleado.stream()
                            .mapToDouble(Empleado::getSalario)
                            .average()
                            .getAsDouble()
                );
    }
}

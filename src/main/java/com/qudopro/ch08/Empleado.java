package com.qudopro.ch08;

public class Empleado {
    private String nombre;
    private String apellido;
    private Fecha fechaNacimiento;
    private Fecha fechaContratacion;

    private static int idEmpleado = 0;

    public Empleado(String nombre, String apellido, Fecha fechaNacimiento, Fecha fechaContratacion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;

        ++idEmpleado;
    }

    public Fecha getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Fecha fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getIdEmpleado() {
        return idEmpleado;
    }

    @Override
    public String toString(){
        return String.format(
                "%s,\s%s\nContratado el dia:\s%s%nFecha de nacimiento:\s%s%nNumero de empleado:\s%d%n%n",
                 apellido, nombre, fechaNacimiento, fechaContratacion, getIdEmpleado()
        );
    }

}

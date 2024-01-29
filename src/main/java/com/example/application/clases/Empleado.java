package com.example.application.clases;

public class Empleado {
    String nombre;
    int cedula;
    int edad;
    String correo;
    private int IDInstitucional;

    public Empleado(String nombre, int cedula, int edad, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIDInstitucional() {
        return IDInstitucional;
    }

    public void setIDInstitucional(int idInstitucional) {
        this.IDInstitucional = idInstitucional;
    }
}

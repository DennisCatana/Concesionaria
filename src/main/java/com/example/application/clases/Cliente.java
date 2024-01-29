package com.example.application.clases;

import java.util.ArrayList;

public class Cliente extends Persona {
    private double presupuesto;
    private ArrayList<Auto> autosComprados = new ArrayList<>();

    public Cliente(){
        super();

    }
    public Cliente(String nombre, int cedula, int edad, String correo, double presupuesto) {
        super();
        this.presupuesto = presupuesto;
        this.nombre = nombre;
    }

    public void agregarAutoComprado(Auto auto) {
        autosComprados.add(auto);
        presupuesto -= auto.precio;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public ArrayList<Auto> obtenerAutosComprados() {
        return autosComprados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

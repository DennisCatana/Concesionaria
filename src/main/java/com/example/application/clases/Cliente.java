package com.example.application.clases;

import java.util.ArrayList;

class Cliente extends Persona {
    private double presupuesto;
    private ArrayList<Auto> autosComprados = new ArrayList<>();

    public Cliente(String nombre, int cedula, int edad, String correo, double presupuesto) {
        super(nombre, cedula, edad, correo);
        this.presupuesto = presupuesto;
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
}

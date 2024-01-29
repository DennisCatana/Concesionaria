package com.example.application.clases;

import java.util.ArrayList;

public class Patio {
    private static Patio instance;
    private ArrayList<Auto> autosDisponibles = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Empleado> empleados = new ArrayList<>(); // Agrega esta lista de empleados


    public static Patio getInstance() {
        return instance;
    }

    public static void setInstance(Patio instance) {
        Patio.instance = instance;
    }

    public void agregarAuto(Auto auto) {
        autosDisponibles.add(auto);
    }

    public boolean eliminarAuto(String matricula) {
        Auto autoEliminar = null;

        for (Auto auto : autosDisponibles) {
            if (auto.getMatricula().equals(matricula)) {
                autoEliminar = auto;
                break;
            }
        }

        if (autoEliminar != null) {
            autosDisponibles.remove(autoEliminar);
            System.out.println("Auto con matrícula " + matricula + " eliminado con éxito.");
            return true; // Devuelve true si el auto se eliminó correctamente
        } else {
            System.out.println("No se encontró ningún auto con esa matrícula.");
            return false; // Devuelve false si la matrícula no se encontró
        }
    }

    public ArrayList<Auto> obtenerAutosDisponibles() {
        return autosDisponibles;
    }

    public void mostrarAutosDisponibles() {
        System.out.println("Autos disponibles en el concesionario:");
        for (Auto auto : autosDisponibles) {
            System.out.println(auto.marca + " " + auto.modelo + " - Matrícula: " + auto.matricula + " - Precio: $" + auto.precio);
        }
    }

    public ArrayList<Cliente> obtenerClientes() {
        return clientes;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public Empleado validarCredencialesEmpleado(String nombre, int IDInstitucional) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre) && empleado.getIDInstitucional() == IDInstitucional) {
                return empleado; // Devuelve el empleado si las credenciales son válidas
            }
        }
        return null; // Devuelve null si las credenciales no son válidas
    }


}

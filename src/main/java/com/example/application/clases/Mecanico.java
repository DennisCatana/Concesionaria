package com.example.application.clases;

import java.util.Scanner;

class Mecanico extends Empleado {

    public Mecanico(String nombre, int cedula, int edad, String correo) {
        super(nombre, cedula, edad, correo);
    }

    // Puedes agregar métodos y atributos específicos de la clase Mecanico si es necesario

    public void hacerMantenimiento(Patio concesionario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la matrícula del auto que necesita mantenimiento: ");
        String matricula = scanner.nextLine();

        Auto autoMantenimiento = buscarAuto(matricula, concesionario);

        if (autoMantenimiento != null) {
            // Implementa aquí la lógica para realizar el mantenimiento del auto
            System.out.println("Mantenimiento realizado con éxito para el auto con matrícula " + matricula);
        } else {
            System.out.println("No se encontró ningún auto con esa matrícula.");
        }
    }

    private Auto buscarAuto(String matricula, Patio concesionario) {
        for (Auto auto : concesionario.obtenerAutosDisponibles()) {
            if (auto.matricula.equals(matricula)) {
                return auto;
            }
        }
        return null;
    }
}

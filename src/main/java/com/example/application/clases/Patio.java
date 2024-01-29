package com.example.application.clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Patio {
    private static Patio instance;
    private ArrayList<Auto> autosDisponibles = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public static Patio getInstance() {
        return instance;
    }

    public static void setInstance(Patio instance) {
        Patio.instance = instance;
    }

    public void agregarAuto(Auto auto) {
        autosDisponibles.add(auto);
    }

    public void eliminarAuto(String matricula) {
        Auto autoEliminar = null;

        for (Auto auto : autosDisponibles) {
            if (auto.matricula.equals(matricula)) {
                autoEliminar = auto;
                break;
            }
        }

        if (autoEliminar != null) {
            autosDisponibles.remove(autoEliminar);
            System.out.println("com.example.application.clases.Auto con matrícula " + matricula + " eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún auto con esa matrícula.");
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

    public void agregarAuto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la matrícula del auto: ");
        String matricula = scanner.nextLine();

        System.out.print("Ingrese el modelo del auto: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese la marca del auto: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el precio del auto: ");
        double precio = scanner.nextDouble();

        Auto nuevoAuto = new Auto(matricula, modelo, marca, precio);
        agregarAuto(nuevoAuto);

        System.out.println("com.example.application.clases.Auto agregado con éxito.");
    }

    public void eliminarAuto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la matrícula del auto a eliminar: ");
        String matriculaEliminar = scanner.nextLine();

        eliminarAuto(matriculaEliminar);
    }

    public void registrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registro de com.example.application.clases.Cliente");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cédula del cliente: ");
        int cedula = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese la edad del cliente: ");
        int edad = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese el correo del cliente: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el presupuesto del cliente: ");
        double presupuesto = scanner.nextDouble();

        Cliente nuevoCliente = new Cliente(nombre, cedula, edad, correo, presupuesto);
        clientes.add(nuevoCliente);
    }

    public ArrayList<Cliente> obtenerClientes() {
        return clientes;
    }
}

package com.example.application.clases;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpleadoVentas extends Empleado {
    private int IDInstitucional;
    private double sueldo;
    private ArrayList<Auto> autosVendidos = new ArrayList<>();

    public EmpleadoVentas(String nombre, int cedula, int edad, String correo, int IDInstitucional, double sueldo) {
        super(nombre, cedula, edad, correo);
        this.IDInstitucional = IDInstitucional;
        this.sueldo = sueldo;
    }

    public static EmpleadoVentas registrarEmpleadoVentas(Scanner scanner) {
        System.out.println("Registro de com.example.application.clases.Empleado de Ventas");
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cédula del empleado: ");
        int cedula = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese la edad del empleado: ");
        int edad = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese el correo del empleado: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el ID institucional del empleado: ");
        int idInstitucional = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese el sueldo del empleado: ");
        double sueldo = scanner.nextDouble();

        return new EmpleadoVentas(nombre, cedula, edad, correo, idInstitucional, sueldo);
    }

    public void menuEmpleadoVentas(Patio concesionario) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido, " + nombre + "! (ID Institucional: " + IDInstitucional + ")");

        int opcionEmpleadoVentas;
        do {
            System.out.println("Menú com.example.application.clases.Empleado Ventas");
            System.out.println("1. Vender com.example.application.clases.Auto");
            System.out.println("2. Observar Autos Vendidos");
            System.out.println("3. Volver al menú principal");
            System.out.print("Ingrese su opción: ");

            opcionEmpleadoVentas = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcionEmpleadoVentas) {
                case 1:
                    venderAuto(concesionario);
                    break;
                case 2:
                    observarAutosVendidos();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcionEmpleadoVentas != 3);
    }

    private void venderAuto(Patio concesionario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la matrícula del auto que desea vender: ");
        String matriculaVendido = scanner.nextLine();

        Auto autoVendido = buscarAuto(matriculaVendido, concesionario);

        if (autoVendido != null) {
            System.out.print("Ingrese el número de cédula del cliente al cual desea vender el auto: ");
            int cedulaCliente = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            Cliente cliente = buscarClientePorCedula(cedulaCliente, concesionario.obtenerClientes());

            if (cliente != null) {
                if (cliente.getPresupuesto() >= autoVendido.precio) {
                    autosVendidos.add(autoVendido);
                    concesionario.eliminarAuto(matriculaVendido);
                    cliente.agregarAutoComprado(autoVendido);
                    System.out.println("Venta realizada con éxito. com.example.application.clases.Auto vendido: " + autoVendido.marca + " " + autoVendido.modelo + " - Matrícula: " + autoVendido.matricula + " - Precio: $" + autoVendido.precio);
                } else {
                    System.out.println("El cliente no tiene presupuesto suficiente para comprar este auto.");
                }
            } else {
                System.out.println("No se encontró ningún cliente con esa cédula.");
            }
        } else {
            System.out.println("No se encontró ningún auto con esa matrícula.");
        }
    }

    private void observarAutosVendidos() {
        if (autosVendidos.isEmpty()) {
            System.out.println("No hay autos vendidos por este empleado de ventas.");
        } else {
            System.out.println("Autos vendidos por este empleado de ventas:");
            double montoTotal = 0.0;

            for (Auto auto : autosVendidos) {
                System.out.println(auto.marca + " " + auto.modelo + " - Matrícula: " + auto.matricula + " - Precio: $" + auto.precio);
                montoTotal += auto.precio;
            }

            System.out.println("Monto total vendido: $" + montoTotal);
        }
    }

    private Cliente buscarClientePorCedula(int cedula, ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.cedula == cedula) {
                return cliente;
            }
        }
        return null;
    }

    private Auto buscarAuto(String matricula, Patio concesionario) {
        for (Auto auto : concesionario.obtenerAutosDisponibles()) {
            if (auto.matricula.equals(matricula)) {
                return auto;
            }
        }
        return null;
    }

    public int getIDInstitucional() {
        return IDInstitucional;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Patio concesionario = new Patio();
        ArrayList<EmpleadoVentas> empleadosVentas = new ArrayList<>();
        int opcion;
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("Menú Principal");
            System.out.println("1. Mostrar Autos Disponibles");
            System.out.println("2. Agregar Auto");
            System.out.println("3. Eliminar Auto");
            System.out.println("4. Registrar Empleado de Ventas");
            System.out.println("5. Acceso Empleados");
            System.out.println("6. Registrar Cliente");
            System.out.println("7. Mostrar Autos Comprados por Cliente");
            System.out.println("8. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    concesionario.mostrarAutosDisponibles();
                    break;
                case 2:
                    concesionario.agregarAuto();
                    break;
                case 3:
                    concesionario.eliminarAuto();
                    break;
                case 4:
                    EmpleadoVentas nuevoEmpleado = EmpleadoVentas.registrarEmpleadoVentas(scanner);
                    empleadosVentas.add(nuevoEmpleado);
                    System.out.println("Empleado de Ventas registrado con éxito.");
                    break;
                case 5:
                    EmpleadoVentas empleadoAccedido = accederMenuEmpleadosVentas(empleadosVentas, concesionario, scanner);
                    if (empleadoAccedido != null) {
                        empleadoAccedido.menuEmpleadoVentas(concesionario);
                    } else {
                        System.out.println("No se encontró el empleado de ventas. Volviendo al menú principal.");
                    }
                    break;
                case 6:
                    concesionario.registrarCliente();
                    System.out.println("Cliente registrado con éxito.");
                    break;
                case 7: // Nueva opción para mostrar autos comprados por cliente
                    mostrarAutosCompradosPorCliente(concesionario, scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static EmpleadoVentas accederMenuEmpleadosVentas(ArrayList<EmpleadoVentas> empleadosVentas, Patio concesionario, Scanner scanner) {
        System.out.print("Ingrese el ID institucional del empleado de ventas: ");
        int idInstitucional = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        for (EmpleadoVentas empleadoVentas : empleadosVentas) {
            if (empleadoVentas.getIDInstitucional() == idInstitucional) {
                return empleadoVentas;
            }
        }
        return null;
    }
    private static void mostrarAutosCompradosPorCliente(Patio concesionario, Scanner scanner) {
        System.out.print("Ingrese la cédula del cliente para mostrar los autos comprados: ");
        int cedulaCliente = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        Cliente cliente = buscarClientePorCedula(cedulaCliente, concesionario.obtenerClientes());
        if (cliente != null) {
            ArrayList<Auto> autosComprados = cliente.obtenerAutosComprados();

            if (!autosComprados.isEmpty()) {
                System.out.println("Autos comprados por el cliente:");
                for (Auto auto : autosComprados) {
                    System.out.println(auto.marca + " " + auto.modelo + " - Matrícula: " + auto.matricula + " - Precio: $" + auto.precio);
                }
            } else {
                System.out.println("El cliente no ha comprado ningún auto.");
            }
        } else {
            System.out.println("No se encontró ningún cliente con esa cédula.");
        }
    }

    private static Cliente buscarClientePorCedula(int cedula, ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                return cliente;
            }
        }
        return null;
    }

}

class Auto {
    String matricula;
    String modelo;
    String marca;
    double precio;

    public Auto(String matricula, String modelo, String marca, double precio) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }
}

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

class Empleado {
    String nombre;
    int cedula;
    int edad;
    String correo;

    public Empleado(String nombre, int cedula, int edad, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
    }
}


class EmpleadoVentas extends Empleado {
    private int IDInstitucional;
    private double sueldo;
    private ArrayList<Auto> autosVendidos = new ArrayList<>();

    public EmpleadoVentas(String nombre, int cedula, int edad, String correo, int IDInstitucional, double sueldo) {
        super(nombre, cedula, edad, correo);
        this.IDInstitucional = IDInstitucional;
        this.sueldo = sueldo;
    }

    public static EmpleadoVentas registrarEmpleadoVentas(Scanner scanner) {
        System.out.println("Registro de Empleado de Ventas");
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
            System.out.println("Menú Empleado Ventas");
            System.out.println("1. Vender Auto");
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
                    System.out.println("Venta realizada con éxito. Auto vendido: " + autoVendido.marca + " " + autoVendido.modelo + " - Matrícula: " + autoVendido.matricula + " - Precio: $" + autoVendido.precio);
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

class Patio {
    private ArrayList<Auto> autosDisponibles = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

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
            System.out.println("Auto con matrícula " + matricula + " eliminado con éxito.");
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

        System.out.println("Auto agregado con éxito.");
    }

    public void eliminarAuto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la matrícula del auto a eliminar: ");
        String matriculaEliminar = scanner.nextLine();

        eliminarAuto(matriculaEliminar);
    }

    public void registrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registro de Cliente");
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

class Persona {
    String nombre;
    int cedula;
    int edad;
    String correo;

    public Persona(String nombre, int cedula, int edad, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
    }

    public int getCedula() {
        return cedula;
    }
}
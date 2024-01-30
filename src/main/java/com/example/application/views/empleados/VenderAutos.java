package com.example.application.views.empleados;

import com.example.application.clases.Patio;
import com.example.application.clases.EmpleadoVentas;
import com.example.application.clases.Auto;
import com.example.application.clases.Cliente;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Vender Autos")
@Route(value = "vender-autos", layout = MainLayout.class)


public class VenderAutos extends VerticalLayout {
    private EmpleadoVentas empleadoVentas;

    private VenderAutos(EmpleadoVentas empleadoVentas) {
        this.empleadoVentas = empleadoVentas;
        initView();
    }

    public static VenderAutos createVenderAutos(EmpleadoVentas empleadoVentas) {
        return new VenderAutos(empleadoVentas);
    }

    private void initView() {
        // Lógica para la vista de la página de venta de autos
        // ...

        Button venderButton = new Button("Vender Auto");
        venderButton.addClickListener(event -> venderAuto());
        add(venderButton);
    }

    private void venderAuto() {
        Patio concesionario = Patio.getInstance();  // Asumiendo que Patio utiliza el patrón Singleton

        // Obtener la matrícula del auto que se desea vender (puedes obtenerla desde un campo de entrada)
        String matriculaVendido = "ABC123";

        Auto autoVendido = buscarAuto(matriculaVendido, concesionario);

        if (autoVendido != null) {
            // Obtener la cédula del cliente al cual se desea vender el auto (puedes obtenerla desde un campo de entrada)
            int cedulaCliente = 123456;

            Cliente cliente = buscarClientePorCedula(cedulaCliente, concesionario);

            if (cliente != null) {
                if (cliente.getPresupuesto() >= autoVendido.getPrecio()) {
                    empleadoVentas.agregarAutoVendido(autoVendido);
                    concesionario.eliminarAuto(matriculaVendido);
                    cliente.agregarAutoComprado(autoVendido);
                    Notification.show("Venta realizada con éxito. Auto vendido: " + autoVendido.getMarca() + " " +
                            autoVendido.getModelo() + " - Matrícula: " + autoVendido.getMatricula() +
                            " - Precio: $" + autoVendido.getPrecio());
                } else {
                    Notification.show("El cliente no tiene presupuesto suficiente para comprar este auto.");
                }
            } else {
                Notification.show("No se encontró ningún cliente con esa cédula.");
            }
        } else {
            Notification.show("No se encontró ningún auto con esa matrícula.");
        }
    }

    private Auto buscarAuto(String matricula, Patio concesionario) {
        for (Auto auto : concesionario.obtenerAutosDisponibles()) {
            if (auto.getMatricula().equals(matricula)) {
                return auto;
            }
        }
        return null;
    }

    private Cliente buscarClientePorCedula(int cedula, Patio concesionario) {
        for (Cliente cliente : concesionario.obtenerClientes()) {
            if (cliente.getCedula() == cedula) {
                return cliente;
            }
        }
        return null;
    }
}

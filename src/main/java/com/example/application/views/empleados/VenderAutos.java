package com.example.application.views.empleados;

import com.example.application.clases.Auto;
import com.example.application.clases.Cliente;
import com.example.application.clases.EmpleadoVentas;
import com.example.application.clases.Patio;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Vender Autos")
@Route(value = "vender-autos", layout = MainLayout.class)
public class VenderAutos extends VerticalLayout {

    @Autowired
    private EmpleadoVentas empleadoVentas;

    @Autowired
    private Patio concesionario;

    public VenderAutos() {
        add(new H2("Vender Autos"));

        TextField matriculaField = new TextField("Matrícula del auto");
        TextField cedulaField = new TextField("Número de cédula del cliente");

        Button venderButton = new Button("Vender Auto");
        venderButton.addClickListener(e -> venderAuto(matriculaField.getValue(), cedulaField.getValue()));

        FormLayout formLayout = new FormLayout(matriculaField, cedulaField, venderButton);
        add(formLayout);
    }

    private void venderAuto(String matriculaVendido, String cedulaCliente) {
        Auto autoVendido = empleadoVentas.buscarAuto(matriculaVendido, concesionario);

        if (autoVendido != null) {
            Cliente cliente = empleadoVentas.buscarClientePorCedula(Integer.parseInt(cedulaCliente), concesionario.obtenerClientes());

            if (cliente != null) {
                if (cliente.getPresupuesto() >= autoVendido.getPrecio()) {
                    empleadoVentas.agregarAutoVendido(autoVendido);
                    concesionario.eliminarAuto(matriculaVendido);
                    cliente.agregarAutoComprado(autoVendido);
                    Notification.show("Venta realizada con éxito. Auto vendido: " +
                            autoVendido.getMarca() + " " + autoVendido.getModelo() + " - Matrícula: " +
                            autoVendido.getMatricula() + " - Precio: $" + autoVendido.getPrecio());
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
}

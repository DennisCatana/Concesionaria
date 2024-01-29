package com.example.application.views.cliente;

import com.example.application.clases.*;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Registrar Cliente")
@Route(value = "registrar-cliente", layout = MainLayout.class)
public class RegistrarClienteView extends VerticalLayout {
    public RegistrarClienteView() {
        H2 header = new H2("Registrar Cliente");

        TextField nombreField = new TextField("Nombre");
        TextField cedulaField = new TextField("Cédula");
        TextField edadField = new TextField("Edad");
        TextField correoField = new TextField("Correo");
        TextField presupuestoField = new TextField("Presupuesto");

        Button registrarBtn = new Button("Registrar", e -> {
            // Lógica para registrar el cliente
            Cliente nuevoCliente = new Cliente(
                    nombreField.getValue(),
                    Integer.parseInt(cedulaField.getValue()),
                    Integer.parseInt(edadField.getValue()),
                    correoField.getValue(),
                    Double.parseDouble(presupuestoField.getValue())
            );

            // Agregar el nuevo cliente a la lista de clientes
            GestorClientes.agregarCliente(nuevoCliente);

            // Mostrar mensaje de confirmación
            Notification.show("Cliente registrado correctamente");
        });

        FormLayout formLayout = new FormLayout(nombreField, cedulaField, edadField, correoField, presupuestoField);
        add(header, formLayout, registrarBtn);

        // Centrar el formulario y el botón verticalmente
        setAlignItems(Alignment.CENTER);
    }
}

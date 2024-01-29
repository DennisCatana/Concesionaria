package com.example.application.views.autos;

import com.example.application.clases.*;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;

@PageTitle("Mostrar Autos Comprados")
@Route(value = "autos-comprados", layout = MainLayout.class)
public class AutosCompradosView extends VerticalLayout {
    public AutosCompradosView() {
        H2 header = new H2("Autos Comprados");

        TextField cedulaField = new TextField("Ingrese la cédula del cliente");
        Button buscarClienteBtn = new Button("Buscar Cliente");

        // Componentes para mostrar la información del cliente y sus autos comprados
        H2 infoClienteHeader = new H2("Información del Cliente");
        VerticalLayout infoClienteLayout = new VerticalLayout();

        buscarClienteBtn.addClickListener(e -> {
            // Lógica para buscar al cliente y mostrar la información de sus autos comprados
            int cedulaCliente = Integer.parseInt(cedulaField.getValue());
            Cliente cliente = buscarClientePorCedula(cedulaCliente);

            if (cliente != null) {
                // Mostrar la información del cliente
                infoClienteLayout.removeAll();
                infoClienteLayout.add(new H2("Nombre: " + cliente.getNombre()),
                        new H2("Cédula: " + cliente.getCedula()),
                        new H2("Presupuesto restante: $" + cliente.getPresupuesto()));

                // Mostrar la información de los autos comprados
                VerticalLayout autosCompradosLayout = new VerticalLayout();
                ArrayList<Auto> autosComprados = cliente.obtenerAutosComprados();

                if (!autosComprados.isEmpty()) {
                    for (Auto auto : autosComprados) {
                        autosCompradosLayout.add(new H2("Auto: " + auto.getMarca() + " " + auto.getModelo()),
                                new H2("Matrícula: " + auto.getMatricula()),
                                new H2("Precio: $" + auto.getPrecio()));
                    }
                    infoClienteLayout.add(new H2("Autos Comprados"), autosCompradosLayout);
                } else {
                    infoClienteLayout.add(new H2("El cliente no ha comprado ningún auto."));
                }
            } else {
                infoClienteLayout.removeAll();
                infoClienteLayout.add(new H2("Cliente no encontrado"));
            }
        });

        FormLayout formLayout = new FormLayout(cedulaField, buscarClienteBtn);
        add(formLayout, header, infoClienteHeader, infoClienteLayout);
        setAlignItems(Alignment.CENTER);
    }

    private Cliente buscarClientePorCedula(int cedula) {
        return GestorClientes.buscarClientePorCedula(cedula);
    }
}

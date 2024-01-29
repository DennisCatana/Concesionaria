package com.example.application.views.autos;

import com.example.application.clases.*;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

@PageTitle("Agregar Autos")
@Route(value = "agregar-autos", layout = MainLayout.class)

public class AgregarAutoView extends VerticalLayout {

    public AgregarAutoView() {
        H2 header = new H2("Agregar Autos");
        TextField matriculaField = new TextField("Matrícula");
        TextField modeloField = new TextField("Modelo");
        TextField marcaField = new TextField("Marca");
        TextField precioField = new TextField("Precio");

        Button agregarBtn = new Button("Agregar", e -> {
            Patio patio = Patio.getInstance();
            if (patio != null) {
                Auto nuevoAuto = new Auto(matriculaField.getValue(),
                        modeloField.getValue(),
                        marcaField.getValue(),
                        Double.parseDouble(precioField.getValue()));
                patio.agregarAuto(nuevoAuto);
                // Mostrar notificación de éxito
                Notification.show("El auto ha sido guardado exitosamente");
            } else {
                // Manejo de error o mensaje de
                Notification.show("Llena los campos correctamente.");
            }
        });
        FormLayout formLayout = new FormLayout(matriculaField, modeloField, marcaField, precioField, agregarBtn);
        add(formLayout, agregarBtn);
        setAlignItems(Alignment.CENTER);
    }
}

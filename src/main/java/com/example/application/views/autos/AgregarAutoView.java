package com.example.application.views.autos;

import com.example.application.clases.Auto;
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
                Notification.show("Error al obtener la instancia del Patio");
            }
        });

        Button venderBtn = new Button("Vender", e -> {
            Patio patio = Patio.getInstance();
            if (patio != null) {
                Auto autoSeleccionado = obtenerAutoSeleccionado();
                if (autoSeleccionado != null) {
                    autoSeleccionado.setEnVenta(true);
                    // Puedes realizar otras acciones relacionadas con la venta aquí
                    Notification.show("El auto ha sido puesto en venta exitosamente");
                } else {
                    Notification.show("Selecciona un auto para vender");
                }
            } else {
                Notification.show("Error al obtener la instancia del Patio");
            }
        });

        FormLayout formLayout = new FormLayout(matriculaField, modeloField, marcaField, precioField, agregarBtn, venderBtn);
        add(header, formLayout);
        setAlignItems(Alignment.CENTER);
    }

    private Auto obtenerAutoSeleccionado() {
        // Implementa la lógica para obtener el auto seleccionado, por ejemplo, de una tabla o lista de autos
        // Retorna el auto seleccionado o null si no hay ninguno seleccionado
        return null;
    }
}

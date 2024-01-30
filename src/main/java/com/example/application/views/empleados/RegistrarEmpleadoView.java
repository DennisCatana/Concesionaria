package com.example.application.views.empleados;

import com.example.application.clases.EmpleadoVentas;
import com.example.application.clases.Patio;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;

@PageTitle("Registrar Empleados de Ventas")
@Route(value = "registrar-empleados-ventas", layout = MainLayout.class)
public class RegistrarEmpleadoView extends VerticalLayout {

    public RegistrarEmpleadoView() {
        H2 header = new H2("Registrar Empleados de Ventas");

        TextField nombreField = new TextField("Nombre");
        TextField cedulaField = new TextField("Cédula");
        TextField edadField = new TextField("Edad");
        TextField correoField = new TextField("Correo");
        TextField idInstitucionalField = new TextField("ID Institucional");
        TextField sueldoField = new TextField("Sueldo");

        Button registrarBtn = new Button("Registrar", e -> {
            // Lógica para registrar el empleado
            EmpleadoVentas nuevoEmpleado = new EmpleadoVentas(
                    nombreField.getValue(),
                    Integer.parseInt(cedulaField.getValue()),
                    Integer.parseInt(edadField.getValue()),
                    correoField.getValue(),
                    Integer.parseInt(idInstitucionalField.getValue()),
                    Double.parseDouble(sueldoField.getValue())
            );

            // Agrega el nuevo empleado al Patio (concesionario)
            Patio.getInstance().agregarEmpleado(nuevoEmpleado);

            // Muestra notificación de éxito
            Notification.show("Empleado registrado con éxito").setPosition(Notification.Position.MIDDLE);

            System.out.println("Registro de usuario - Nombre: " + nuevoEmpleado.getNombre() + ", ID Institucional: " + nuevoEmpleado.getIDInstitucional());
        });
        FormLayout formLayout = new FormLayout(nombreField, cedulaField, edadField, correoField, idInstitucionalField, sueldoField, registrarBtn);
        add(formLayout, registrarBtn);
        setAlignItems(Alignment.CENTER);
    }
}

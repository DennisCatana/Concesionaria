package com.example.application.views.empleados;

import com.example.application.clases.*;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Acceso a Empleados")
@Route(value = "acceso-empleados", layout = MainLayout.class)
public class AccesoEmpleadoView extends VerticalLayout {

    public AccesoEmpleadoView(){
        H2 header = new H2("Acceso a Empleados");

        TextField nombreField = new TextField("Nombre");
        TextField idInstitucionalField = new TextField("ID Institucional");

        Button loginBtn = new Button("Iniciar Sesión", e -> {
            String nombre = nombreField.getValue();
            int idInstitucional = Integer.parseInt(idInstitucionalField.getValue());

            Empleado empleado = Patio.getInstance().validarCredencialesEmpleado(nombre, idInstitucional);

            if (empleado != null) {
                Notification.show("Bienvenido, " + nombre ).setPosition(Notification.Position.MIDDLE);
                UI.getCurrent().navigate("menu-empleados");
            } else {
                Notification.show("Credenciales incorrectas").setPosition(Notification.Position.MIDDLE);
            }
        });

        add(new FormLayout(nombreField, idInstitucionalField, loginBtn));
    }
}

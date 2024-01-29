package com.example.application.views.registrarEmpleado;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Registrar Empleados de Ventas")
@Route(value = "registrar-empleados-ventas", layout = MainLayout.class)

public class RegistrarEmpleadoView extends VerticalLayout {
    public RegistrarEmpleadoView(){
        H2 header = new H2("Registrar Empleados de Ventas");
    }
}

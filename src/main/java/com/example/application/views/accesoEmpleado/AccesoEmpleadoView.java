package com.example.application.views.accesoEmpleado;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Acceso a Empleados")
@Route(value = "acceso-empleados", layout = MainLayout.class)

public class AccesoEmpleadoView extends VerticalLayout {
    public AccesoEmpleadoView(){
        H2 header = new H2("Acceso a Empleados");
    }
}

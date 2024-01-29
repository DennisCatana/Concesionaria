package com.example.application.views.empleados;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Menú Empleados")
@Route(value = "menu-empleados", layout = MainLayout.class)
public class SubMenuView extends VerticalLayout {
    H2 header = new H2("Menú Empleados");
}

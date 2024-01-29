package com.example.application.views.cliente;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Registrar Cliente")
@Route(value = "registrar-cliente", layout = MainLayout.class)

public class RegistrarClienteView extends VerticalLayout{
    public RegistrarClienteView(){
        H2 header = new H2("Registrar Cliente");
    }
}

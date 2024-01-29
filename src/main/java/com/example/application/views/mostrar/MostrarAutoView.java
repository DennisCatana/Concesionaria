package com.example.application.views.mostrar;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Mostrar Autos")
@Route(value = "mostrar-autos", layout = MainLayout.class)

public class MostrarAutoView extends VerticalLayout {
    public MostrarAutoView(){
        H2 header = new H2("Mostrar Autos");
    }
}

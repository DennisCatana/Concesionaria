package com.example.application.views.agregar;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Agregar Autos")
@Route(value = "agregar-autos", layout = MainLayout.class)

public class AgregarAutoView extends VerticalLayout {
    public AgregarAutoView(){
        H2 header = new H2("Agregar Autos");
    }

}

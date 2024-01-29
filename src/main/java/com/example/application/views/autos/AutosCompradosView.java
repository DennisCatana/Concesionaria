package com.example.application.views.autos;

import com.example.application.clases.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Mostrar Autos Comprados")
@Route(value = "autos-comprados", layout = MainLayout.class)


public class AutosCompradosView extends VerticalLayout {
    public AutosCompradosView(){
        H2 h2 = new H2("Autos Comprados");
    }
}

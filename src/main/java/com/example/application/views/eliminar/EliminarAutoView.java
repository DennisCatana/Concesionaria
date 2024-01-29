package com.example.application.views.eliminar;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Eliminar Auto")
@Route(value = "eliminar-auto", layout = MainLayout.class)


public class EliminarAutoView extends VerticalLayout {
    public EliminarAutoView(){
        H2 header = new H2("Eliminar Auto");
    }
}

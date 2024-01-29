package com.example.application.views.eliminar;

import com.example.application.clases.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;


@PageTitle("Eliminar Auto")
@Route(value = "eliminar-auto", layout = MainLayout.class)


public class EliminarAutoView extends VerticalLayout {
    public EliminarAutoView(){

        H2 header = new H2("Eliminar Auto");

        TextField matriculaField = new TextField("Matrícula");

        Button eliminarBtn = new Button("Eliminar", e -> {
            // Lógica para eliminar el auto
            Patio.getInstance().eliminarAuto(matriculaField.getValue());
        });

        add(new FormLayout(matriculaField, eliminarBtn));
    }
}

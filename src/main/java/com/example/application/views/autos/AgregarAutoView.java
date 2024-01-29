package com.example.application.views.autos;

import com.example.application.clases.*;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

@PageTitle("Agregar Autos")
@Route(value = "agregar-autos", layout = MainLayout.class)

public class AgregarAutoView extends VerticalLayout {
    public AgregarAutoView(){

        H2 header = new H2("Agregar Autos");
        TextField matriculaField = new TextField("Matrícula");
        TextField modeloField = new TextField("Modelo");
        TextField marcaField = new TextField("Marca");
        TextField precioField = new TextField("Precio");

        Button agregarBtn = new Button("Agregar", e -> {
            // Lógica para agregar el auto
            Patio.getInstance().agregarAuto(new Auto(matriculaField.getValue(), modeloField.getValue(), marcaField.getValue(), Double.parseDouble(precioField.getValue())));
        });


        add(new FormLayout(matriculaField, modeloField, marcaField, precioField, agregarBtn));
    }
}

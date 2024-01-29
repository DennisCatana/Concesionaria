package com.example.application.views.autos;

import com.example.application.clases.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;

@PageTitle("Eliminar Auto")
@Route(value = "eliminar-auto", layout = MainLayout.class)


public class EliminarAutoView extends VerticalLayout {
    public EliminarAutoView(){

        H2 header = new H2("Eliminar Auto");

        TextField matriculaField = new TextField("Matrícula");

        Button eliminarBtn = new Button("Eliminar", e -> confirmarEliminacion(matriculaField.getValue()));

        add(new FormLayout(matriculaField, eliminarBtn));
    }

    private void confirmarEliminacion(String matricula) {
        ConfirmDialog confirmDialog = new ConfirmDialog(
                "Confirmar eliminación",
                "¿Estás seguro de que deseas eliminar el auto con matrícula " + matricula + "?",
                "Sí", event -> eliminarAuto(matricula),
                "Cancelar", event -> {}
        );

        confirmDialog.open();
    }

    private void eliminarAuto(String matricula) {
        if (Patio.getInstance().eliminarAuto(matricula)) {
            Notification.show("Auto eliminado exitosamente");
        } else {
            Notification.show("Matrícula no encontrada");
        }
    }
}

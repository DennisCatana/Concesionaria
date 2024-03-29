package com.example.application.views.autos;

import com.example.application.clases.*;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.grid.Grid;

@PageTitle("Mostrar Autos")
@Route(value = "mostrar-autos", layout = MainLayout.class)

public class MostrarAutoView extends VerticalLayout {

    public MostrarAutoView() {
        H2 header = new H2("Mostrar Autos");

        Grid<Auto> grid = new Grid<>();
        grid.setItems(Patio.getInstance().obtenerAutosDisponibles());

        // Configuración del grid
        grid.addColumn(Auto::getMatricula).setHeader("Matrícula");
        grid.addColumn(Auto::getModelo).setHeader("Modelo");
        grid.addColumn(Auto::getMarca).setHeader("Marca");
        grid.addColumn(Auto::getPrecio).setHeader("Precio");
        add(grid);
    }
}

package com.example.application.views.empleados;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;

@PageTitle("Menú Empleados")
@Route(value = "menu-empleados", layout = MainLayout.class)

public class SubMenuView extends VerticalLayout {
    H2 header = new H2("Menú Empleados");
    public SubMenuView() {
        Button venderAutosBtn = new Button("Vender Autos", e -> {
            UI.getCurrent().navigate("vender-autos");
        });

        Button observarMenuPrincipalBtn = new Button("Observar Autos", e -> {
            UI.getCurrent().navigate("observar-autos");
        });

        Button volverMenuPrincipalBtn = new Button("Volver al Menú Principal", e -> {
            UI.getCurrent().navigate("hello");
        });

        add(venderAutosBtn, observarMenuPrincipalBtn,volverMenuPrincipalBtn);
    }
}

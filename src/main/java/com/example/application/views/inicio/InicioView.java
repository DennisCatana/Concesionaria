package com.example.application.views.inicio;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Inicio")
@Route(value = "inicio", layout = MainLayout.class)
public class InicioView extends VerticalLayout {

    public InicioView() {
        setSpacing(false);

        Image img = new Image("images/Consesionaria.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("Bienvenidos ");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

        // Añadir un botón y configurar la redirección a otra ruta
        Button goToOtraRutaButton = new Button("Entrar");
        goToOtraRutaButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("eliminar-auto")));
        add(goToOtraRutaButton);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}

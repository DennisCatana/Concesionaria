package com.example.application.views.salir;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Salir")
@Route(value = "salir", layout = MainLayout.class)
public class SalirView extends VerticalLayout {

    public SalirView() {
        setSpacing(false);

        Image img = new Image("images/Consesionaria.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("Concensionaria");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("Espero que nuestro servicio haya sido de su agrado 🤗"));

        Button goToOtraRutaButton = new Button("Salir");
        goToOtraRutaButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("inicio")));
        add(goToOtraRutaButton);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}

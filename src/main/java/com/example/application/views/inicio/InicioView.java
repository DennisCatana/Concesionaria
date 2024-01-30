package com.example.application.views.inicio;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Inicio")
@RouteAlias(value = "")
@Route(value = "inicio")
public class InicioView extends VerticalLayout {

    public InicioView() {
        setSpacing(false);

        Image img = new Image("images/Consesionaria.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("Concensionaria PEPIN");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("Conduce tus sueños, vive la experiencia 🤗"));

        Button goToOtraRutaButton = new Button("Ingresar");
        goToOtraRutaButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("mision")));
        add(goToOtraRutaButton);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}

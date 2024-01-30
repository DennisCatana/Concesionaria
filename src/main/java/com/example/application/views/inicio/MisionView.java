package com.example.application.views.inicio;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Mision")
@Route(value = "mision", layout = MainLayout.class)
public class MisionView extends VerticalLayout {

    public MisionView() {
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        H2 header = new H2("Misión de Concesionarias Pepin");
        header.addClassNames(LumoUtility.Margin.Top.XLARGE, LumoUtility.Margin.Bottom.MEDIUM);
        add(header);

        Paragraph paragraph = new Paragraph("Nuestra misión es comprometernos a ofrecer a nuestros valiosos clientes una experiencia excepcional durante todo el proceso de compra de automóviles. Nos esforzamos por proporcionar vehículos de la más alta calidad, respaldados por un servicio personalizado que refleje nuestro compromiso con la excelencia. En cada interacción, nos esforzamos por superar las expectativas, anticipando y satisfaciendo las necesidades individuales de cada cliente. Creemos firmemente en la importancia de construir relaciones a largo plazo con aquellos que confían en nosotros para satisfacer sus necesidades automotrices. No se trata solo de vender un automóvil; se trata de establecer una conexión significativa y duradera. Nos esforzamos por comprender las preferencias, los estilos de vida y las metas de cada cliente, para poder ofrecer soluciones que se alineen perfectamente con sus expectativas. Para lograr nuestra misión, nos comprometemos a mantener los más altos estándares de calidad en nuestra selección de vehículos. Cada automóvil en nuestro inventario es sometido a rigurosas inspecciones para garantizar su estado óptimo y rendimiento confiable. Buscamos asociarnos con fabricantes y proveedores que compartan nuestro compromiso con la calidad y la innovación en la industria automotriz. La personalización del servicio es un pilar fundamental de nuestra misión. Reconocemos la singularidad de cada cliente y adaptamos nuestras interacciones y servicios para satisfacer sus necesidades específicas. Desde la primera consulta hasta el servicio postventa, nos esforzamos por brindar atención personalizada que demuestre nuestro compromiso inquebrantable con la satisfacción del cliente. Además, entendemos que la transparencia y la integridad son fundamentales en todas nuestras transacciones.");
        add(paragraph);

        setSizeFull();
    }
}

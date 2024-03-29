package com.example.application.views;

import com.example.application.views.inicio.MisionView;
import com.example.application.views.empleados.AccesoEmpleadoView;
import com.example.application.views.autos.AutosCompradosView;
import com.example.application.views.cliente.RegistrarClienteView;
import com.example.application.views.autos.AgregarAutoView;
import com.example.application.views.autos.EliminarAutoView;
import com.example.application.views.autos.MostrarAutoView;
import com.example.application.views.empleados.RegistrarEmpleadoView;
import com.example.application.views.salir.SalirView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Consesionaria de Autos");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Mision", MisionView.class, LineAwesomeIcon.HOME_SOLID.create()));
        nav.addItem(new SideNavItem("Mostrar Autos Disponibles", MostrarAutoView.class, LineAwesomeIcon.CAR_SOLID.create()));
        nav.addItem(new SideNavItem("Agregar Autos", AgregarAutoView.class, LineAwesomeIcon.PLUS_SOLID.create()));
        nav.addItem(new SideNavItem("Eliminar Auto", EliminarAutoView.class, LineAwesomeIcon.TRASH_SOLID.create()));
        nav.addItem(new SideNavItem("Registrar Empleado de Ventas", RegistrarEmpleadoView.class, LineAwesomeIcon.USER_SOLID.create()));
        nav.addItem(new SideNavItem("Acceso Empleados", AccesoEmpleadoView.class, LineAwesomeIcon.KEY_SOLID.create()));
        nav.addItem(new SideNavItem("Registrar Cliente", RegistrarClienteView.class, LineAwesomeIcon.USER_PLUS_SOLID.create()));
        nav.addItem(new SideNavItem("Mostrar Autos Comprados", AutosCompradosView.class, LineAwesomeIcon.SHOPPING_CART_SOLID.create()));
        nav.addItem(new SideNavItem("Salir", SalirView.class, LineAwesomeIcon.SIGN_OUT_ALT_SOLID.create()));


        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}

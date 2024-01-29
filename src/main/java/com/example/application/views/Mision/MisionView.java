package com.example.application.views.Mision;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Mision")
@Route(value = "hello", layout = MainLayout.class)

public class MisionView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public MisionView() {

    }

}

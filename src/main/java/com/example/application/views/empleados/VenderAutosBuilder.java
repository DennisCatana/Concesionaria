package com.example.application.views.empleados;

import com.example.application.clases.EmpleadoVentas;

public class VenderAutosBuilder {
    private EmpleadoVentas empleadoVentas;

    public VenderAutosBuilder setEmpleadoVentas(EmpleadoVentas empleadoVentas) {
        this.empleadoVentas = empleadoVentas;
        return this;
    }

    public VenderAutos createVenderAutos() {
        // Asegúrate de que la clase VenderAutos tenga el método createVenderAutos definido
        return VenderAutos.createVenderAutos(empleadoVentas);
    }
}

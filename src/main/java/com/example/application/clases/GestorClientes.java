package com.example.application.clases;

import java.util.ArrayList;

public class GestorClientes {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public static void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static ArrayList<Cliente> obtenerClientes() {
        return listaClientes;
    }

    // Puedes agregar más métodos según sea necesario para gestionar la lista de clientes
}

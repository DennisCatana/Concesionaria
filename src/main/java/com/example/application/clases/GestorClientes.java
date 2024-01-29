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

    // Corregir el nombre de la lista en el siguiente método
    public static Cliente buscarClientePorCedula(int cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula() == cedula) {
                return cliente;
            }
        }
        return null;
    }
}

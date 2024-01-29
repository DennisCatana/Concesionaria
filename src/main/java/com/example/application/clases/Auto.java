package com.example.application.clases;

public class Auto {
    String matricula;
    String modelo;
    String marca;
    double precio;

    public Auto() {
    }

    public Auto(String matricula, String modelo, String marca, double precio) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

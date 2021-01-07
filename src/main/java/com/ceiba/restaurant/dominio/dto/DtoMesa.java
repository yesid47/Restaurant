package com.ceiba.restaurant.dominio.dto;

public class DtoMesa {
    private int idMesa;
    private int capacidadPersonas;
    private int numeroMesa;
    private double precio;

    public DtoMesa(int idMesa, int capacidadPersonas, int numeroMesa, double precio) {
        this.idMesa= idMesa;
        this.capacidadPersonas = capacidadPersonas;
        this.numeroMesa = numeroMesa;
        this.precio = precio;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

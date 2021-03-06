package com.ceiba.restaurant.aplicacion.comando;

public class ComandoMesa {
    private int idMesa;
    private int capacidadPersonas;
    private int numeroMesa;
    private double precio;

    public ComandoMesa(){

    }


    public ComandoMesa(int capacidadPersonas, int numeroMesa, double precio) {
        this.capacidadPersonas = capacidadPersonas;
        this.numeroMesa = numeroMesa;
        this.precio = precio;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public double getPrecio() {
        return precio;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}

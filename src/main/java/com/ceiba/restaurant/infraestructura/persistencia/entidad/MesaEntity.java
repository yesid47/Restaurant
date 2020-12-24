package com.ceiba.restaurant.infraestructura.persistencia.entidad;


import javax.persistence.*;

@Entity(name="mesa")
@Table(name="mesa")
public class MesaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="capacidad", nullable = false)
    private int capacidad;
    @Column(name="numero_mesa", nullable = false, unique = true)
    private int numero_mesa;
    @Column(name="precio",nullable = false)
    private double precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumeroMesa() {
        return numero_mesa;
    }

    public void setNumeroMesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }
}

package com.ceiba.restaurant.infraestructura.persistencia.entidad;

import javax.persistence.*;

@Entity
@Table(name="rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="nombreRol")
    private String nombreRol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}

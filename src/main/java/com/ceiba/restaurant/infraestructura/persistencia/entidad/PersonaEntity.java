package com.ceiba.restaurant.infraestructura.persistencia.entidad;

import javax.persistence.*;

@Entity(name="persona")
@Table(name="persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="cedula", nullable = false, unique = true )
    private String cedula;
    @Column(name="celular", nullable = false)
    private long celular;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="direccion")
    private String direccion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}

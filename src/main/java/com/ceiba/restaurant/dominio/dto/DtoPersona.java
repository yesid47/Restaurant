package com.ceiba.restaurant.dominio.dto;

public class DtoPersona {

    private long idPersona;
    private String nombre;
    private String cedula;
    private long celular;
    private String email;
    private String direccion;

    public DtoPersona(long idPersona, String nombre, String cedula, long celular, String email, String direccion) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
    }

    public long getIdPersona() {
        return idPersona;
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

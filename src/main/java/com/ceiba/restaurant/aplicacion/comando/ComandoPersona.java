package com.ceiba.restaurant.aplicacion.comando;

public class ComandoPersona {
    private long idPersona;
    private String nombre;
    private String cedula;
    private long celular;
    private String email;
    private String direccion;

    public ComandoPersona(){

    }

    public ComandoPersona(String nombre, String cedula, long celular, String email, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public long getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }
}

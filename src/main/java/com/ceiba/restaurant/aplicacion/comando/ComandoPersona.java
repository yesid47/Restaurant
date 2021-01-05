package com.ceiba.restaurant.aplicacion.comando;

public class ComandoPersona {
    private long idPersona;
    private String nombrePersona;
    private String cedula;
    private long celular;
    private String email;
    private String direccion;

    public ComandoPersona(){

    }

    public ComandoPersona(String nombrePersona, String cedula, long celular, String email, String direccion) {
        this.nombrePersona = nombrePersona;
        this.cedula = cedula;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
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

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}

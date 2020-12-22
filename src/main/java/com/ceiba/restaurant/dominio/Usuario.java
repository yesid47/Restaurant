package com.ceiba.restaurant.dominio;

public class Usuario {
    private int idUser;
    private String nombreUsuario;
    private String password;
    private Persona persona;
    private Rol rol;

    public Usuario(){
        super();
    }

    public Usuario(int idUser, String nombreUsuario, String password, Persona persona, Rol rol) {
        this.idUser = idUser;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.persona = persona;
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

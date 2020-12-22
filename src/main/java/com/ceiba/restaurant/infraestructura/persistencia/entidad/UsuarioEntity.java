package com.ceiba.restaurant.infraestructura.persistencia.entidad;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @OneToOne
    @JoinColumn(name="id_persona",referencedColumnName="id")
    private PersonaEntity persona;

    @OneToOne
    @JoinColumn(name="id_rol",referencedColumnName="id")
    private RolEntity rol;
    @Column(name="nombreUsuario")
    private String nombreUsuario;
    @Column(name="password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonaEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
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

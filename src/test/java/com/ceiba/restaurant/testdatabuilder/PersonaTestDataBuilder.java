package com.ceiba.restaurant.testdatabuilder;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;

public class PersonaTestDataBuilder {

    private static final long ID = 1;
    private static final String NOMBRE = "Yesid Orrego Restrepo";
    private static final long CELULAR = 310604579;
    private static final String EMAIL = "orrego47@gmail.com";
    private static final String DIRECCION = "CLL 50 # 51-62";
    private static final String CEDULA = "1045025118";

    private String nombre;
    private String email;
    private String direccion;
    private long celular;
    private String cedula;

    public PersonaTestDataBuilder() {
        this.nombre = NOMBRE;
        this.email= EMAIL;
        this.direccion= DIRECCION;
        this.celular = CELULAR;
        this.cedula = CEDULA;
    }

    public Persona build(){
        return new Persona(ID,this.nombre,this.cedula,this.celular,this.email,this.direccion);
    }

    public DtoPersona buildDto(){
        return new DtoPersona(ID,this.nombre,this.cedula,this.celular,this.email,this.direccion);
    }

    public ComandoPersona buildComando(){
        return new ComandoPersona(this.nombre,this.cedula,this.celular,this.email,this.direccion);
    }

    public PersonaEntity buildEntity(){
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(ID);
        personaEntity.setCedula(this.cedula);
        personaEntity.setCelular(this.celular);
        personaEntity.setNombre(this.nombre);
        personaEntity.setDireccion(this.direccion);
        personaEntity.setEmail(this.email);
        return personaEntity;
    }
}

package com.ceiba.restaurant.testdatabuilder;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.dominio.Persona;

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
        return new Persona(1,this.nombre,this.cedula,this.celular,this.email,this.direccion);
    }

    public ComandoPersona buildComando(){
        return new ComandoPersona(this.nombre,this.cedula,this.celular,this.email,this.direccion);
    }
}

package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;

import java.util.ArrayList;
import java.util.List;

public final class PersonaBuilder {

    private PersonaBuilder(){

    }

    public static Persona convertirADominio(PersonaEntity personaEntity){

        Persona persona= null;
        if(personaEntity != null){
            persona = new Persona(personaEntity.getId(),personaEntity.getNombre(),personaEntity.getCedula(),personaEntity.getCelular(),personaEntity.getEmail(),personaEntity.getDireccion());
        }
        return persona;
    }

    public static PersonaEntity convertirAEntity(Persona persona){
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(persona.getIdPersona());
        personaEntity.setNombre(persona.getNombrePersona());
        personaEntity.setCedula(persona.getCedula());
        personaEntity.setCelular(persona.getCelular());
        personaEntity.setEmail(persona.getEmail());
        personaEntity.setDireccion(persona.getDireccion());

        return personaEntity;
    }

    public static List<Persona> convertirADominio(List<PersonaEntity> listaEntity){

        ArrayList<Persona> listaDominio = new ArrayList<>();
        for (PersonaEntity persona : listaEntity){
            listaDominio.add(convertirADominio(persona));
        }

        return listaDominio;
    }
}

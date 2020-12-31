package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;

import javax.persistence.Query;
import java.util.ArrayList;

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

    public static ArrayList<Persona> convertirADominio(Query query){

        ArrayList<Persona> listaDominio = new ArrayList<>();
        ArrayList<PersonaEntity> listaEntity= (ArrayList<PersonaEntity>) query.getResultList();
        for (PersonaEntity persona : listaEntity){
            listaDominio.add(convertirADominio(persona));
        }

        return listaDominio;
    }
}

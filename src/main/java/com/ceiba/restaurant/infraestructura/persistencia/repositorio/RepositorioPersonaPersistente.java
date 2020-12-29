package com.ceiba.restaurant.infraestructura.persistencia.repositorio;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import com.ceiba.restaurant.infraestructura.persistencia.builder.PersonaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioPersonaPersistente implements RepositorioPersona {

    private static final String FIND_ALL ="SELECT persona FROM persona as persona";
    private static final String OBTENER_PERSONA = "SELECT persona FROM persona as persona WHERE persona.cedula = :cedula";

    private EntityManager entityManager;

    public RepositorioPersonaPersistente(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void agregar(Persona persona) {
        entityManager.persist(PersonaBuilder.convertirAEntity(persona));
    }

    @Override
    public Persona obtenerPorId(long id) {
        PersonaEntity personaEntity = obtenerPersonaEntityPorId(id);
        return PersonaBuilder.convertirADominio(personaEntity);
    }

    private PersonaEntity obtenerPersonaEntityPorId(long id) {
        return entityManager.find(PersonaEntity.class,id);
    }

    @Override
    public List<Persona> listarTodo() {
        Query query = entityManager.createQuery(FIND_ALL);
        ArrayList<Persona> listaDominio = new ArrayList<>();
        ArrayList<PersonaEntity> listaEntity= (ArrayList<PersonaEntity>) query.getResultList();
        for (PersonaEntity persona : listaEntity){
            listaDominio.add(PersonaBuilder.convertirADominio(persona));
        }

        return listaDominio;
    }

    @Override
    public void eliminar(long id) {
        if(obtenerPorId(id)!=null){
            /*Query query = entityManager.createQuery(DELETE_PERSONA);
            query.setParameter("id",id);*/
        }
    }

    @Override
    public Persona obtenerPorCedula(String cedula) {
        try {
            PersonaEntity personaEntity = obtenerPersonaEntityPorCedula(cedula);
            return PersonaBuilder.convertirADominio(personaEntity);
        }catch (Exception e){
            return null;
        }
    }

    private PersonaEntity obtenerPersonaEntityPorCedula(String cedula) {
        try {
            Query query = entityManager.createQuery(OBTENER_PERSONA);
            query.setParameter("cedula", cedula);

            return (PersonaEntity) query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
}

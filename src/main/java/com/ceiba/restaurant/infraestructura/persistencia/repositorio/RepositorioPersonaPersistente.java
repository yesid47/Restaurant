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

    private static final String FIND_ALL ="SELECT id,cedula,celular,direccion,email,nombre FROM persona";
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
        PersonaEntity query = entityManager.find(PersonaEntity.class,id);//createQuery(PERSONA_FIND_BY_ID);

        return query;
    }

    @Override
    public List<Persona> listarPersonas() {
        Query query = entityManager.createQuery(FIND_ALL);
        return (ArrayList<Persona>) query.getResultList();
    }

    @Override
    public void eliminar(long id) {
        if(obtenerPorId(id)!=null){
            /*Query query = entityManager.createQuery(DELETE_PERSONA);
            query.setParameter("id",id);*/
        }
    }
}

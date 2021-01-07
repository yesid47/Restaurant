package com.ceiba.restaurant.infraestructura.persistencia.repositorio;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import com.ceiba.restaurant.infraestructura.persistencia.builder.PersonaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.repositorio.jpa.RepositorioPersonaJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioPersonaPersistente implements RepositorioPersona, RepositorioPersonaJPA {

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
    public DtoPersona obtenerPorId(long id) {
        PersonaEntity personaEntity = obtenerPersonaEntityPorId(id);
        return PersonaBuilder.convertirADominio(personaEntity);
    }

    @Override
    public PersonaEntity obtenerPersonaEntityPorId(long id) {
        return entityManager.find(PersonaEntity.class,id);
    }

    @Override
    public List<DtoPersona> listarTodo() {
        Query query = entityManager.createQuery(FIND_ALL);
        ArrayList<PersonaEntity> listaEntity= (ArrayList<PersonaEntity>) query.getResultList();
        return PersonaBuilder.convertirADominio(listaEntity);
    }

    @Override
    public void eliminar(long id) {
        PersonaEntity personaEntity = obtenerPersonaEntityPorId(id);
        entityManager.remove(personaEntity);
    }

    @Override
    public DtoPersona obtenerPorCedula(String cedula) {
        PersonaEntity personaEntity = obtenerPersonaEntityPorCedula(cedula);
        return PersonaBuilder.convertirADominio(personaEntity);
    }

    @Override
    public void actualizar(Persona persona) {
        entityManager.merge(PersonaBuilder.convertirAEntity(persona));
    }

    @Override
    public PersonaEntity obtenerPersonaEntityPorCedula(String cedula) {
            Query query = entityManager.createQuery(OBTENER_PERSONA);
            query.setParameter("cedula", cedula);

            return (PersonaEntity) query.getResultList().stream().findFirst().orElse(null);
    }
}

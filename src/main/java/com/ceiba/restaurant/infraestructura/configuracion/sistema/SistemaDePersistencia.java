package com.ceiba.restaurant.infraestructura.configuracion.sistema;

import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import com.ceiba.restaurant.infraestructura.configuracion.conexion.ConexionJPA;
import com.ceiba.restaurant.infraestructura.persistencia.repositorio.RepositorioPersonaPersistente;

import javax.persistence.EntityManager;

public class SistemaDePersistencia {
    private EntityManager entityManager;

    public SistemaDePersistencia(){
        this.entityManager= new ConexionJPA().createEntityManager();
    }

    public RepositorioPersona obtenerRepositorioPersonas(){
        return new RepositorioPersonaPersistente(entityManager);
    }

}

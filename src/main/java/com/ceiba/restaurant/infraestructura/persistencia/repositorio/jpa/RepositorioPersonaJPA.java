package com.ceiba.restaurant.infraestructura.persistencia.repositorio.jpa;

import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;

public interface RepositorioPersonaJPA {

    PersonaEntity obtenerPersonaEntityPorCedula(String cedula);

    PersonaEntity obtenerPersonaEntityPorId(long id);
}

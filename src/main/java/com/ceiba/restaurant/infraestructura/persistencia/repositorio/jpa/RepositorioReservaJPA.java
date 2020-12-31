package com.ceiba.restaurant.infraestructura.persistencia.repositorio.jpa;

import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;

public interface RepositorioReservaJPA {

    ReservaEntity obtenerEntityPorId(long id);
}

package com.ceiba.restaurant.infraestructura.persistencia.repositorio.jpa;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;

public interface RepositorioMesaJPA {

    MesaEntity obtenerEntityPorNumero(int numero);
    MesaEntity obtenerEntityPorId(int id);
}

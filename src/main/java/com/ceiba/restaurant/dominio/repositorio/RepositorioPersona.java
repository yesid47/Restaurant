package com.ceiba.restaurant.dominio.repositorio;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.dto.DtoPersona;

import java.util.List;

public interface RepositorioPersona {
    void agregar(Persona persona);

    DtoPersona obtenerPorId(long id);

    List<DtoPersona> listarTodo();

    void eliminar(long id);

    DtoPersona obtenerPorCedula(String cedula);

    void actualizar(Persona persona);
}

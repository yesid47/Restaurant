package com.ceiba.restaurant.dominio.repositorio;

import com.ceiba.restaurant.dominio.Persona;

import java.util.List;

public interface RepositorioPersona {
    void agregar(Persona persona);

    Persona obtenerPorId(long id);

    List<Persona> listarPersonas();

    void eliminar(long id);
}

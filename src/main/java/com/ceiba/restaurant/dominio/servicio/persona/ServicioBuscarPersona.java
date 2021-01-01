package com.ceiba.restaurant.dominio.servicio.persona;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioBuscarPersona {
    private final RepositorioPersona repositorioPersona;

    public ServicioBuscarPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public Persona ejecutar(long id){
        return this.repositorioPersona.obtenerPorId(id);
    }

    public Persona ejecutar(String cedula){
        return this.repositorioPersona.obtenerPorCedula(cedula);
    }
}

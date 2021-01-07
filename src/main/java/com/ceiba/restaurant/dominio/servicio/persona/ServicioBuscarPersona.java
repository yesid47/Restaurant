package com.ceiba.restaurant.dominio.servicio.persona;

import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioBuscarPersona {
    private final RepositorioPersona repositorioPersona;

    public ServicioBuscarPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public DtoPersona ejecutar(long id){
        return this.repositorioPersona.obtenerPorId(id);
    }

    public DtoPersona ejecutar(String cedula){
        return this.repositorioPersona.obtenerPorCedula(cedula);
    }
}

package com.ceiba.restaurant.dominio.servicio.persona;

import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarPersonas {
    private final RepositorioPersona repositorioPersona;

    public ServicioListarPersonas(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public List<DtoPersona> ejecutar(){
        return this.repositorioPersona.listarTodo();
    }
}

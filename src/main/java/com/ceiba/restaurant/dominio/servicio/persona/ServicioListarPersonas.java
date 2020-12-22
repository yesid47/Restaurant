package com.ceiba.restaurant.dominio.servicio.persona;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarPersonas {
    private RepositorioPersona repositorioPersona;

    public ServicioListarPersonas(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public List<Persona> ejecutar(){
        return this.repositorioPersona.listarPersonas();
    }
}

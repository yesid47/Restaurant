package com.ceiba.restaurant.dominio.servicio.persona;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearPersona {
    private RepositorioPersona repositorioPersona;

    public ServicioCrearPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Persona persona){
        this.repositorioPersona.agregar(persona);
    }
}

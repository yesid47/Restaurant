package com.ceiba.restaurant.dominio.servicio.persona;

import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioEliminarPersona {
    private final RepositorioPersona repositorioPersona;

    public ServicioEliminarPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(long id){

        this.repositorioPersona.eliminar(id);
    }
}

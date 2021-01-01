package com.ceiba.restaurant.dominio.servicio.persona;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionPersonaExiste;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearPersona {
    private final RepositorioPersona repositorioPersona;

    private static final String LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA = "La persona ya existe en el sistema";

    public ServicioCrearPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Persona persona){
        validarExistenciaPrevia(persona);
        this.repositorioPersona.agregar(persona);
    }

    private void validarExistenciaPrevia(Persona persona){
        if(this.repositorioPersona.obtenerPorCedula(persona.getCedula()) != null){
            throw new ExcepcionPersonaExiste(LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}

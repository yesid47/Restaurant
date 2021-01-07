package com.ceiba.restaurant.aplicacion.fabrica;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.dominio.Persona;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {

    public Persona crear(ComandoPersona comandoPersona){
        Persona persona = new Persona(comandoPersona.getNombrePersona(),comandoPersona.getCedula(), comandoPersona.getCelular(), comandoPersona.getEmail(),
                comandoPersona.getDireccion());
        persona.setIdPersona(comandoPersona.getIdPersona());
        return persona;
    }


}

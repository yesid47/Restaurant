package com.ceiba.restaurant.aplicacion.fabrica;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.dominio.Persona;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {

    public Persona crearPersona(ComandoPersona comandoPersona){
        return new Persona(comandoPersona.getIdPersona(),comandoPersona.getNombre(),comandoPersona.getCedula(), comandoPersona.getCelular(), comandoPersona.getEmail(),
                comandoPersona.getDireccion());
    }


}
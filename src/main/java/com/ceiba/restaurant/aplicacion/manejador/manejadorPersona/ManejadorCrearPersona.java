package com.ceiba.restaurant.aplicacion.manejador.manejadorPersona;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaPersona;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.servicio.persona.ServicioCrearPersona;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearPersona {

    private final ServicioCrearPersona servicioCrearPersona;
    private final FabricaPersona fabricaPersona;

    public ManejadorCrearPersona(ServicioCrearPersona servicioPersona, FabricaPersona fabricaPersona)
    {
        this.servicioCrearPersona = servicioPersona;
        this.fabricaPersona= fabricaPersona;
    }

    @Transactional
    public void ejecutar(ComandoPersona comandoPersona){
        Persona persona = this.fabricaPersona.crearPersona(comandoPersona);
        this.servicioCrearPersona.ejecutar(persona);
    }
}

package com.ceiba.restaurant.aplicacion.manejador.persona;


import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaPersona;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.servicio.persona.ServicioActualizarPersona;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarPersona {

    private final ServicioActualizarPersona servicioActualizarPersona;
    private final FabricaPersona fabricaPersona;

    public ManejadorActualizarPersona(ServicioActualizarPersona servicioActualizarPersona, FabricaPersona fabricaPersona)
    {
        this.servicioActualizarPersona = servicioActualizarPersona;
        this.fabricaPersona= fabricaPersona;
    }

    @Transactional
    public void ejecutar(ComandoPersona comandoPersona){
        Persona persona = this.fabricaPersona.crear(comandoPersona);
        this.servicioActualizarPersona.ejecutar(persona);
    }
}

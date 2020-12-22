package com.ceiba.restaurant.aplicacion.manejador.manejadorPersona;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.servicio.persona.ServicioListarPersonas;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ManejadorListarPersonas {

    private final ServicioListarPersonas servicioListarPersonas;
    //private final FabricaPersona fabricaPersona;

    public ManejadorListarPersonas(ServicioListarPersonas servicioListarPersonas)
    {
        this.servicioListarPersonas = servicioListarPersonas;
        //this.fabricaPersona= fabricaPersona;
    }

    @Transactional
    public List<Persona> ejecutar(){
       // Persona persona = this.fabricaPersona.crearPersona(comandoPersona);
        return this.servicioListarPersonas.ejecutar();
    }
}

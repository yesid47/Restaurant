package com.ceiba.restaurant.aplicacion.manejador.persona;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.servicio.persona.ServicioListarPersonas;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ManejadorListarPersonas {

    private final ServicioListarPersonas servicioListarPersonas;

    public ManejadorListarPersonas(ServicioListarPersonas servicioListarPersonas)
    {
        this.servicioListarPersonas = servicioListarPersonas;
    }

    @Transactional
    public List<DtoPersona> ejecutar(){
        return this.servicioListarPersonas.ejecutar();
    }
}

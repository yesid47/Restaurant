package com.ceiba.restaurant.aplicacion.manejador.persona;

import com.ceiba.restaurant.dominio.servicio.persona.ServicioEliminarPersona;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarPersona {

    private final ServicioEliminarPersona servicioEliminarPersona;

    public ManejadorEliminarPersona(ServicioEliminarPersona servicioEliminarPersona)
    {
        this.servicioEliminarPersona = servicioEliminarPersona;
    }

    @Transactional
    public void ejecutar(long id){
        this.servicioEliminarPersona.ejecutar(id);
    }
}

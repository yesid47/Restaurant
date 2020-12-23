package com.ceiba.restaurant.aplicacion.manejador.manejadorpersona;

import com.ceiba.restaurant.dominio.servicio.persona.ServicioEliminarPersona;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarPersona {

    private final ServicioEliminarPersona servicioEliminarPersona;
    //private final FabricaPersona fabricaPersona;

    public ManejadorEliminarPersona(ServicioEliminarPersona servicioEliminarPersona)
    {
        this.servicioEliminarPersona = servicioEliminarPersona;
        //this.fabricaPersona= fabricaPersona;
    }

    @Transactional
    public void ejecutar(long id){
        this.servicioEliminarPersona.ejecutar(id);
    }
}

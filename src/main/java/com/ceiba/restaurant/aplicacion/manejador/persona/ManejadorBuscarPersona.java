package com.ceiba.restaurant.aplicacion.manejador.persona;

import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.servicio.persona.ServicioBuscarPersona;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorBuscarPersona {

    private final ServicioBuscarPersona servicioBuscarPersona;

    public ManejadorBuscarPersona(ServicioBuscarPersona servicioBuscarPersona)
    {
        this.servicioBuscarPersona = servicioBuscarPersona;
    }

    @Transactional
    public DtoPersona ejecutar(long id){
        return this.servicioBuscarPersona.ejecutar(id);
    }

    @Transactional
    public DtoPersona ejecutar(String cedula){
        return this.servicioBuscarPersona.ejecutar(cedula);
    }
}

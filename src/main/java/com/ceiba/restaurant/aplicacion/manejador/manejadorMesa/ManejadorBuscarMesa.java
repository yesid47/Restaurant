package com.ceiba.restaurant.aplicacion.manejador.manejadorMesa;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.servicio.mesa.ServicioBuscarMesa;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorBuscarMesa {

    private final ServicioBuscarMesa servicioBuscarMesa;

    public ManejadorBuscarMesa(ServicioBuscarMesa servicioBuscarPersona)
    {
        this.servicioBuscarMesa = servicioBuscarPersona;
    }

    @Transactional
    public Mesa ejecutar(int id){
        return this.servicioBuscarMesa.ejecutar(id);
    }
}

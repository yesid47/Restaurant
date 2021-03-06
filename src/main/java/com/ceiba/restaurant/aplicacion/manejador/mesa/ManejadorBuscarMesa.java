package com.ceiba.restaurant.aplicacion.manejador.mesa;

import com.ceiba.restaurant.dominio.dto.DtoMesa;
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
    public DtoMesa ejecutar(int numero){
        return this.servicioBuscarMesa.ejecutar(numero);
    }
}

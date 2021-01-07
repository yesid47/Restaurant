package com.ceiba.restaurant.aplicacion.manejador.mesa;

import com.ceiba.restaurant.dominio.servicio.mesa.ServicioEliminarMesa;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarMesa {

    private ServicioEliminarMesa servicioEliminarMesa;

    public ManejadorEliminarMesa(ServicioEliminarMesa servicioEliminarMesa) {
        this.servicioEliminarMesa = servicioEliminarMesa;
    }

    @Transactional
    public void ejecutar(int numero){
        this.servicioEliminarMesa.ejecutar(numero);
    }
}

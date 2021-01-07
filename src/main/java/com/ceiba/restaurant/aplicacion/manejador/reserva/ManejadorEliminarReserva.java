package com.ceiba.restaurant.aplicacion.manejador.reserva;

import com.ceiba.restaurant.dominio.servicio.reserva.ServicioEliminarReserva;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarReserva {

    private ServicioEliminarReserva servicioEliminarReserva;

    public ManejadorEliminarReserva(ServicioEliminarReserva servicioEliminarReserva) {
        this.servicioEliminarReserva = servicioEliminarReserva;
    }

    @Transactional
    public void ejecutar(long id){
        servicioEliminarReserva.ejecutar(id);
    }
}

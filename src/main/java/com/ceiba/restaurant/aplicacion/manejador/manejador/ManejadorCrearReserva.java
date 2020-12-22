package com.ceiba.restaurant.aplicacion.manejador.manejador;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.servicio.reserva.ServicioCrearReserva;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearReserva {

    private final ServicioCrearReserva servicioCrearReserva;

    public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva)
    {
        this.servicioCrearReserva = servicioCrearReserva;
    }

    //@Transactional
    //Reserva reserva = this.fabricaProducto.crearProducto(comandoProducto);
    /*public void ejecutar(Reserva reserva){
        this.servicioCrearReserva.ejecutar(reserva);
    }*/
}

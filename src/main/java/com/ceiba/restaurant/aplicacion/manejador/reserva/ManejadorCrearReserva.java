package com.ceiba.restaurant.aplicacion.manejador.reserva;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaReserva;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.servicio.reserva.ServicioCrearReserva;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearReserva {

    private final ServicioCrearReserva servicioCrearReserva;
    private final FabricaReserva fabricaReserva;

    public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva, FabricaReserva fabricaReserva)
    {
        this.servicioCrearReserva = servicioCrearReserva;
        this.fabricaReserva= fabricaReserva;
    }

    @Transactional
    public void ejecutar(ComandoReserva comandoReserva){
        Reserva reserva = this.fabricaReserva.crear(comandoReserva);
        this.servicioCrearReserva.ejecutar(reserva);
    }

}

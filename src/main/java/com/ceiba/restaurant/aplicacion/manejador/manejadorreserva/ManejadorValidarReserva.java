package com.ceiba.restaurant.aplicacion.manejador.manejadorreserva;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaReserva;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.servicio.reserva.ServicioValidarReserva;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorValidarReserva {
    private final ServicioValidarReserva servicioValidarReserva;
    private final FabricaReserva fabricaReserva;

    public ManejadorValidarReserva(ServicioValidarReserva servicioValidarReserva, FabricaReserva fabricaReserva)
    {
        this.servicioValidarReserva = servicioValidarReserva;
        this.fabricaReserva= fabricaReserva;
    }

    @Transactional
    public boolean ejecutar(ComandoReserva comandoReserva){
        Reserva reserva = this.fabricaReserva.crear(comandoReserva);
        return this.servicioValidarReserva.ejecutar(reserva);
    }
}

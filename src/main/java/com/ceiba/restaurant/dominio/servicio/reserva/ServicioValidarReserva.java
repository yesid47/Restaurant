package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

@Component
public class ServicioValidarReserva {
    private RepositorioReserva repositorioReserva;

    public ServicioValidarReserva(RepositorioReserva repositorioReserva){
        this.repositorioReserva = repositorioReserva;

    }

    public boolean ejecutar(Reserva reserva){

        return this.repositorioReserva.validarDisponibilidad(reserva.getFecha(),reserva.getHoraInicio(),reserva.getHoraFinal(), reserva.getMesa());
    }
}

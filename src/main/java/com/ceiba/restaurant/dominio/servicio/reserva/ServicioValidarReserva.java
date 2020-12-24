package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.infraestructura.persistencia.repositorio.RepositorioReservaPersistente;
import org.springframework.stereotype.Component;

@Component
public class ServicioValidarReserva {
    private RepositorioReservaPersistente repositorioReservaPersistente;

    public ServicioValidarReserva(RepositorioReservaPersistente repositorioReservaPersistente){
        this.repositorioReservaPersistente = repositorioReservaPersistente;

    }

    public boolean ejecutar(Reserva reserva){
        return this.repositorioReservaPersistente.validarDisponibilidad(reserva.getFecha(),reserva.getHoraInicio(),reserva.getHoraFinal(), reserva.getMesa());
    }
}

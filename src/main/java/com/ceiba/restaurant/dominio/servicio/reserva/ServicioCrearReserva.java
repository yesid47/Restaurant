package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.infraestructura.persistencia.repositorio.RepositorioReservaPersistente;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearReserva {
    private RepositorioReservaPersistente repositorioReservaPersistente;

    public ServicioCrearReserva(RepositorioReservaPersistente repositorioReservaPersistente){
        this.repositorioReservaPersistente = repositorioReservaPersistente;
    }

    public void ejecutar(Reserva reserva){
        this.repositorioReservaPersistente.agregar(reserva);
    }

}

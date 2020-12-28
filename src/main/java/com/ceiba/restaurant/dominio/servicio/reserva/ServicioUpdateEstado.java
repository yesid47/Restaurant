package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ServicioUpdateEstado {

    RepositorioReserva repositorioReserva;

    public ServicioUpdateEstado(RepositorioReserva repositorioReserva){
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(LocalDate fechaActual, LocalTime horaActual){
        this.repositorioReserva.actualizarEstado(fechaActual,horaActual);
    }
}

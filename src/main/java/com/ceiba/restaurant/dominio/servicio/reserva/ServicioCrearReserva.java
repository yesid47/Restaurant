package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearReserva {
    private RepositorioReserva repositorioReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReservaPersistente){
        this.repositorioReserva = repositorioReservaPersistente;

    }

    public void ejecutar(Reserva reserva){
        if(this.repositorioReserva.validarDisponibilidad(reserva.getFecha(),reserva.getHoraInicio(),reserva.getHoraFinal(), reserva.getMesa())){
            //exception
        }
        else{
            this.repositorioReserva.agregar(reserva);
        }
    }

}

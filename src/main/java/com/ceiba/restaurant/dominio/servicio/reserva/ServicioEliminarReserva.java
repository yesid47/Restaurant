package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

@Component
public class ServicioEliminarReserva {

    private RepositorioReserva repositorioReserva;

    public ServicioEliminarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(long id){
        this.repositorioReserva.eliminar(id);
    }
}

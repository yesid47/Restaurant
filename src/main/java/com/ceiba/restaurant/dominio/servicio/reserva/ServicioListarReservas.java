package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarReservas {

    private RepositorioReserva repositorioReserva;

    public ServicioListarReservas(RepositorioReserva repositorioReserva){
        this.repositorioReserva = repositorioReserva;
    }

    public List<Reserva> ejecutar(){
        return this.repositorioReserva.listarTodo();
    }
}

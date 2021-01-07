package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.dto.DtoReserva;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarReservas {

    private final RepositorioReserva repositorioReserva;

    public ServicioListarReservas(RepositorioReserva repositorioReserva){
        this.repositorioReserva = repositorioReserva;
    }

    public List<DtoReserva> ejecutar(){
        return this.repositorioReserva.listarTodo();
    }
}

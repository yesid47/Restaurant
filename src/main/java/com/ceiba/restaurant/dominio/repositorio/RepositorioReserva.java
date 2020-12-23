package com.ceiba.restaurant.dominio.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;

import java.util.List;

public interface RepositorioReserva {

    Reserva obtenerPorId(long id);

    void agregar(Reserva reserva);

    Mesa obtenerMesaReservada(int id);

    List<Reserva> listarTodo();
}

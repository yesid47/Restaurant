package com.ceiba.restaurant.dominio.repositorio;


import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;

public interface RepositorioReserva {

    Reserva obtenerReservaPorId(long id);

    void agregar(Reserva reserva);

    Mesa obtenerMesaReservada(int id);
}

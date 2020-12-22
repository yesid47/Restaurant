package com.ceiba.restaurant.infraestructura.persistencia.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaPersistente implements RepositorioReserva {


    @Override
    public Reserva obtenerReservaPorId(long id) {
        return null;
    }

    @Override
    public void agregar(Reserva reserva) {

    }


    @Override
    public Mesa obtenerMesaReservada(int id) {
        return null;
    }
}

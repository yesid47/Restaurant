package com.ceiba.restaurant.dominio.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.dto.DtoReserva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface RepositorioReserva {

    DtoReserva obtenerPorId(long id);

    void agregar(Reserva reserva);

    List<DtoReserva> listarTodo();

    boolean validarDisponibilidad(LocalDate fecha, LocalTime horaInicial, LocalTime horaFinal, Mesa mesa);

    void actualizarEstado(LocalDate fechaActual, LocalTime horaActual);

    void eliminar(long id);
}

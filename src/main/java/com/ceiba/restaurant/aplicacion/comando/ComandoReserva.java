package com.ceiba.restaurant.aplicacion.comando;

import java.time.LocalDate;
import java.time.LocalTime;

public class ComandoReserva {

    private long idReserva;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private ComandoPersona persona;
    private ComandoMesa mesa;


    public ComandoReserva(LocalDate fecha, LocalTime horaInicio, ComandoPersona persona, ComandoMesa mesa) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.persona = persona;
        this.mesa= mesa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public ComandoPersona getPersona() {
        return persona;
    }

    public ComandoMesa getMesa() {
        return mesa;
    }
}

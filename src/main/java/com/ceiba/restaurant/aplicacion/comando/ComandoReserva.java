package com.ceiba.restaurant.aplicacion.comando;


import java.time.LocalDate;
import java.time.LocalTime;

public class ComandoReserva {

    private long idReserva;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private long persona;
    private int mesa;

    public ComandoReserva(){
        super();
    }

    public ComandoReserva(LocalDate fecha, LocalTime horaInicio, long persona, int mesa) {
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

    public long getPersona() {
        return persona;
    }

    public int getMesa() {
        return mesa;
    }
}

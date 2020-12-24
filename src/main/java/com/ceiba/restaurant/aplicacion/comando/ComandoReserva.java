package com.ceiba.restaurant.aplicacion.comando;


import java.time.LocalDate;
import java.time.LocalTime;

public class ComandoReserva {

    private long idReserva;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private String persona;
    private int mesa;

    public ComandoReserva(){
        super();
    }

    public ComandoReserva(LocalDate fecha, LocalTime horaInicio, String persona, int mesa) {
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

    public String getPersona() {
        return persona;
    }

    public int getMesa() {
        return mesa;
    }
}

package com.ceiba.restaurant.dominio;


import java.time.LocalDate;
import java.time.LocalTime;


public class Reserva {
    private long idReserva;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private Persona persona;
    private Mesa mesa;

    public Reserva (){

    }

    public Reserva(long idReserva, LocalDate fecha, LocalTime horaInicio, Persona persona, Mesa mesa) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.persona = persona;
        this.mesa = mesa;
        this.horaFinal = calcularHoraFinal(horaInicio);
    }


    public LocalTime calcularHoraFinal(LocalTime horaInicio){

        return horaInicio.plusMinutes(120);
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }


    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

package com.ceiba.restaurant.dominio.dto;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;

import java.time.LocalDate;
import java.time.LocalTime;

public class DtoReserva {

    private long idReserva;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private DtoPersona persona;
    private DtoMesa mesa;
    private double valorAPagar;
    private boolean estado;

    public DtoReserva(LocalDate fecha, LocalTime horaInicio, LocalTime horaFinal, DtoPersona persona, DtoMesa mesa, double valorAPagar, boolean estado) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.persona = persona;
        this.mesa = mesa;
        this.valorAPagar = valorAPagar;
        this.estado = estado;
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

    public DtoPersona getPersona() {
        return persona;
    }

    public void setPersona(DtoPersona persona) {
        this.persona = persona;
    }

    public DtoMesa getMesa() {
        return mesa;
    }

    public void setMesa(DtoMesa mesa) {
        this.mesa = mesa;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

package com.ceiba.restaurant.dominio;


import java.util.Date;

public class Reserva {
    private long idReserva;
    private Date fecha;
    private Date horaInicio;
    private Date horaFinal;
    private Usuario usuario;
    private Mesa mesa;

    public Reserva(){
        super();
    }

    public Reserva(long idReserva, Date fecha, Date horaInicio, Date horaFinal, Usuario usuario, Mesa mesa) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.usuario = usuario;
        this.mesa= mesa;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}

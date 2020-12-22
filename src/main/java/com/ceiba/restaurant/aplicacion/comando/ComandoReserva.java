package com.ceiba.restaurant.aplicacion.comando;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Usuario;

import java.util.Date;

public class ComandoReserva {

    private long idReserva;
    private Date fecha;
    private Date horaInicio;
    private Date horaFinal;
    private Usuario usuario;
    private Mesa mesa;

    public ComandoReserva(){
        super();
    }

    public ComandoReserva(Date fecha, Date horaInicio, Date horaFinal, Usuario usuario, Mesa mesa) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.usuario = usuario;
        this.mesa= mesa;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Mesa getMesa() {
        return mesa;
    }
}

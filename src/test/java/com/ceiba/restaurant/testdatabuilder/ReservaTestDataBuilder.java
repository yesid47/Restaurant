package com.ceiba.restaurant.testdatabuilder;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaTestDataBuilder {

    private static final long ID = 1;
    private static final LocalDate FECHA = LocalDate.parse("2021-01-07");
    private static final LocalTime HORA_INICIAL = LocalTime.parse("10:20");
    private static final ComandoPersona PERSONA = new PersonaTestDataBuilder().buildComando();
    private static final ComandoMesa MESA = new MesaTestDataBuilder().buildComando();

    private LocalDate fecha;
    private LocalTime horaInicial;
    private ComandoPersona persona;
    private ComandoMesa mesa;

    public ReservaTestDataBuilder(){
        this.fecha = FECHA;
        this.horaInicial = HORA_INICIAL;
        this.persona = PERSONA;
        this.mesa = MESA;
    }

    public ComandoReserva buildComando(){
        return new ComandoReserva(this.fecha,this.horaInicial,this.persona,this.mesa);
    }
}

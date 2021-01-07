package com.ceiba.restaurant.testdatabuilder;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.dto.DtoMesa;
import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.dto.DtoReserva;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaTestDataBuilder {

    private static final long ID = 1;
    private static final LocalDate FECHA = LocalDate.parse("2200-01-04");
    private static final LocalTime HORA_INICIAL = LocalTime.parse("10:20");
    private static final LocalTime HORA_FINAL = LocalTime.parse("12:20");
    private static final double VALOR_A_PAGAR = 10000;
    private static final boolean ESTADO = true;
    private static final ComandoPersona COMANDO_PERSONA = new PersonaTestDataBuilder().buildComando();
    private static final ComandoMesa COMANDO_MESA = new MesaTestDataBuilder().buildComando();

    private static final DtoPersona PERSONADTO = new PersonaTestDataBuilder().buildDto();
    private static final DtoMesa MESADTO = new MesaTestDataBuilder().buildDto();

    private static final Persona PERSONA = new PersonaTestDataBuilder().build();
    private static final Mesa MESA = new MesaTestDataBuilder().build();

    private static final PersonaEntity PERSONA_ENTITY = new PersonaTestDataBuilder().buildEntity();
    private static final MesaEntity MESA_ENTITY = new MesaTestDataBuilder().buildEntity();

    private LocalDate fecha;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private ComandoPersona persona;
    private ComandoMesa mesa;
    private double valorAPagar;
    private boolean estado;

    public ReservaTestDataBuilder(){
        this.fecha = FECHA;
        this.horaInicial = HORA_INICIAL;
        this.persona = COMANDO_PERSONA;
        this.mesa = COMANDO_MESA;
        this.estado = ESTADO;
        this.horaFinal = HORA_FINAL;
        this.valorAPagar = VALOR_A_PAGAR;
    }

    public DtoReserva buildDto(){

        DtoReserva reserva=  new DtoReserva(this.fecha,this.horaInicial,this.horaFinal,PERSONADTO,MESADTO,this.valorAPagar,this.estado);
        reserva.setIdReserva(ID);
        return reserva;
    }

    public Reserva build(){

        Reserva reserva=  new Reserva(1,this.fecha,this.horaInicial,PERSONA,MESA);
        return reserva;
    }


    public ComandoReserva buildComando(){
        return new ComandoReserva(this.fecha,this.horaInicial,this.persona,this.mesa);
    }

    public ReservaEntity buildEntity(){
        ReservaEntity reservaEntity = new ReservaEntity();
        reservaEntity.setValorPagar(this.valorAPagar);
        reservaEntity.setEstado(this.estado);
        reservaEntity.setHoraFinal(this.horaFinal);
        reservaEntity.setFecha(this.fecha);
        reservaEntity.setId(this.ID);
        reservaEntity.setHoraInicial(this.horaInicial);
        reservaEntity.setPersona(PERSONA_ENTITY);
        reservaEntity.setMesa(MESA_ENTITY);

        return reservaEntity;
    }
}

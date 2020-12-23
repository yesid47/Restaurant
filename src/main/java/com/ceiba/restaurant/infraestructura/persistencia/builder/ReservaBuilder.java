package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;

public class ReservaBuilder {
    ReservaBuilder(){}

    public static Reserva convertirADominio(ReservaEntity reservaEntity){
        Reserva reserva= null;

        if(reservaEntity!=null){
            Persona persona = PersonaBuilder.convertirADominio(reservaEntity.getPersona());
            Mesa mesa = MesaBuilder.convertirADominio(reservaEntity.getMesa());
            reserva = new Reserva(reservaEntity.getId(),reservaEntity.getFecha(),reservaEntity.getHoraInicial(),persona,mesa);
        }

        return reserva;
    }

    public static ReservaEntity convertirAEntity(Reserva reserva){
        ReservaEntity reservaEntity = new ReservaEntity();
        PersonaEntity personaEntity = PersonaBuilder.convertirAEntity(reserva.getPersona());
        MesaEntity mesaEntity = MesaBuilder.convertirAEntity(reserva.getMesa());

        reservaEntity.setId(reserva.getIdReserva());
        reservaEntity.setFecha(reserva.getFecha());
        reservaEntity.setHoraInicial(reserva.getHoraInicio());
        reservaEntity.setHoraFinal(reserva.getHoraFinal());
        reservaEntity.setPersona(personaEntity);
        reservaEntity.setMesa(mesaEntity);
        return reservaEntity;
    }
}

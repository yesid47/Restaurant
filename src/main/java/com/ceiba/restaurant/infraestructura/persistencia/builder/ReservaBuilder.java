package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;

public class ReservaBuilder {
    ReservaBuilder(){}

    public static Reserva convertirADominio(ReservaEntity reservaEntity){
        Reserva reserva= null;

        if(reservaEntity!=null){
            reserva = new Reserva(reservaEntity.getId(),reservaEntity.getFecha(),reservaEntity.getHoraInicial(),reservaEntity.getHoraFinal(),null,null);
        }

        return reserva;
    }

    public static ReservaEntity convertirAEntity(Reserva reserva){
        ReservaEntity reservaEntity = new ReservaEntity();
        reservaEntity.setId(reserva.getIdReserva());
        reservaEntity.setFecha(reserva.getFecha());
        reservaEntity.setHoraInicial(reserva.getHoraInicio());
        reservaEntity.setHoraFinal(reserva.getHoraFinal());
        reservaEntity.setUsuario(null);
        reservaEntity.setMesa(null);

        return reservaEntity;
    }
}

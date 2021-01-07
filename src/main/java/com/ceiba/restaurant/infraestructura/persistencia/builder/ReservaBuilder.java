package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.dto.DtoMesa;
import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.dto.DtoReserva;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;

import java.util.ArrayList;
import java.util.List;

public final class ReservaBuilder {
    private ReservaBuilder(){}

    public static DtoReserva convertirADominio(ReservaEntity reservaEntity){
        DtoReserva reserva= null;

        if(reservaEntity!=null){
            DtoPersona persona = PersonaBuilder.convertirADominio(reservaEntity.getPersona());
            DtoMesa mesa = MesaBuilder.convertirADto(reservaEntity.getMesa());
            reserva = new DtoReserva(reservaEntity.getFecha(),reservaEntity.getHoraInicial(),reservaEntity.getHoraFinal(),
                    persona,mesa,reservaEntity.getValorPagar(), reservaEntity.getEstado());
            reserva.setIdReserva(reservaEntity.getId());
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
        reservaEntity.setValorPagar(reserva.getValorAPagar());
        reservaEntity.setEstado(reserva.getEstado());
        return reservaEntity;
    }

    public static List<DtoReserva> convertirADominio(List<ReservaEntity> listaEntity){

        ArrayList<DtoReserva> listaDominio = new ArrayList<>();

        for (ReservaEntity reserva : listaEntity){
            listaDominio.add(convertirADominio(reserva));
        }

        return listaDominio;
    }

    public static boolean convertirABool(List<ReservaEntity> lista){
        if(lista.isEmpty()){
            return false;
        }
        else{
            return true;
        }

    }
}

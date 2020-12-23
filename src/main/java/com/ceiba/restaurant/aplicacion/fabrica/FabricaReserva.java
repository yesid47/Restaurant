package com.ceiba.restaurant.aplicacion.fabrica;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva, Persona persona, Mesa mesa){

        //LocalDate fecha = LocalDate.parse(comandoReserva.getFecha());
        //LocalTime horaInicio = LocalTime.parse(comandoReserva.getHoraInicio());
        //Persona persona = ;
        return new Reserva(comandoReserva.getIdReserva(),comandoReserva.getFecha(),comandoReserva.getHoraInicio(),persona,mesa);
    }

}

package com.ceiba.restaurant.aplicacion.fabrica;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import org.springframework.stereotype.Component;


@Component
public class FabricaReserva {

    private final FabricaMesa fabricaMesa;
    private final FabricaPersona fabricaPersona;

    public FabricaReserva(FabricaMesa fabricaMesa, FabricaPersona fabricaPersona) {
        this.fabricaMesa = fabricaMesa;
        this.fabricaPersona = fabricaPersona;
    }


    public Reserva crear(ComandoReserva comandoReserva){

        Persona persona = this.fabricaPersona.crear(comandoReserva.getPersona());
        Mesa mesa = this.fabricaMesa.crear(comandoReserva.getMesa());

        return new Reserva(comandoReserva.getIdReserva(),comandoReserva.getFecha(),comandoReserva.getHoraInicio(),persona,mesa);
    }

}

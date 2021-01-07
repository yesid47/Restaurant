package com.ceiba.restaurant.aplicacion;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaMesa;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaPersona;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaReserva;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.restaurant.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FabricaReservaTest {

    @Test
    public void crearTest(){
        //arrange
        ComandoReserva comandoReserva = new ReservaTestDataBuilder().buildComando();
        Reserva reservaEsperada = new ReservaTestDataBuilder().build();

        Persona persona = new PersonaTestDataBuilder().build();
        Mesa mesa = new MesaTestDataBuilder().build();

        FabricaPersona fabricaPersona = mock(FabricaPersona.class);
        FabricaMesa fabricaMesa = mock(FabricaMesa.class);

        when(fabricaPersona.crear(comandoReserva.getPersona())).thenReturn(persona);
        when(fabricaMesa.crear(comandoReserva.getMesa())).thenReturn(mesa);

        FabricaReserva fabricaReserva = new FabricaReserva(fabricaMesa,fabricaPersona);
        //act
        Reserva reserva = fabricaReserva.crear(comandoReserva);
        //assert
        Assertions.assertEquals(mesa,reserva.getMesa());
        Assertions.assertEquals(persona,reserva.getPersona());
        Assertions.assertEquals(reservaEsperada.getFecha(),reserva.getFecha());
        Assertions.assertEquals(reservaEsperada.getHoraInicio(),reserva.getHoraInicio());

    }
}

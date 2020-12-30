package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComandoReservaTest {

    @Test
    public void reservaComandoTest(){
        //arrange
        ComandoReserva comandoEsperado = new ReservaTestDataBuilder().buildComando();
        //act
        ComandoReserva comandoReserva= new ComandoReserva(comandoEsperado.getFecha(),comandoEsperado.getHoraInicio(), comandoEsperado.getPersona(), comandoEsperado.getMesa());
        //assert
        Assertions.assertEquals(comandoEsperado.getFecha(),comandoReserva.getFecha());
        Assertions.assertEquals(comandoEsperado.getHoraInicio(),comandoReserva.getHoraInicio());
        Assertions.assertEquals(comandoEsperado.getPersona(),comandoReserva.getPersona());
        Assertions.assertEquals(comandoEsperado.getMesa(),comandoReserva.getMesa());
    }
}

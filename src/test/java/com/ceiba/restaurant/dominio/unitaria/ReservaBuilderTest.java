package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.infraestructura.persistencia.builder.ReservaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;
import com.ceiba.restaurant.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservaBuilderTest {

    @Test
    public void convertirADominioTest(){
        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder();
        ReservaEntity reservaEntity = reservaTestDataBuilder.buildEntity();
        Reserva reservaEsperada = reservaTestDataBuilder.build();
        //act
        Reserva reserva = ReservaBuilder.convertirADominio(reservaEntity);
        //assert
        Assertions.assertEquals(reservaEsperada.getIdReserva(),reserva.getIdReserva());
        Assertions.assertEquals(reservaEsperada.getFecha(),reserva.getFecha());
        Assertions.assertEquals(reservaEsperada.getHoraInicio(),reserva.getHoraInicio());
        Assertions.assertEquals(reservaEsperada.getHoraFinal(),reserva.getHoraFinal());
        Assertions.assertEquals(reservaEsperada.getEstado(),reserva.getEstado());
    }
}

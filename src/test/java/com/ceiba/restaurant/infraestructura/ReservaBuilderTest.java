package com.ceiba.restaurant.infraestructura;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.infraestructura.persistencia.builder.PersonaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.builder.ReservaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.restaurant.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void convertirADominioNULLTest(){
        //arrange
        ReservaEntity reservaEntity = null;
        //act
        Reserva reserva = ReservaBuilder.convertirADominio(reservaEntity);
        //assert
        Assertions.assertNull(reserva);
    }


    @Test
    public void convertirAEntityTest(){
        //arrange

        ReservaEntity reservaEntityEsperada = new ReservaTestDataBuilder().buildEntity();
        Reserva reserva = new ReservaTestDataBuilder().build();
        //act
        ReservaEntity reservaEntity = ReservaBuilder.convertirAEntity(reserva);
        //assert
        Assertions.assertEquals(reservaEntityEsperada.getId(),reservaEntity.getId());
        Assertions.assertEquals(reservaEntityEsperada.getFecha(),reservaEntity.getFecha());
        Assertions.assertEquals(reservaEntityEsperada.getHoraInicial(),reservaEntity.getHoraInicial());
        Assertions.assertEquals(reservaEntityEsperada.getHoraFinal(),reservaEntity.getHoraFinal());
        Assertions.assertEquals(reservaEntityEsperada.getEstado(),reservaEntity.getEstado());
    }

    @Test
    public void convertirADominioListaTest(){
        //arrange
        ReservaEntity reservaEntity= new ReservaTestDataBuilder().buildEntity();
        ArrayList<ReservaEntity> listaEntities= new ArrayList<>();
        listaEntities.add(reservaEntity);
        //act
        List<Reserva> reservas = ReservaBuilder.convertirADominio(listaEntities);
        //assert
        Assertions.assertNotNull(reservas.get(0));
    }


}
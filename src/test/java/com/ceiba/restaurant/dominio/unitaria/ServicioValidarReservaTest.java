package com.ceiba.restaurant.dominio.unitaria;


import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaInexistente;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import com.ceiba.restaurant.dominio.servicio.reserva.ServicioValidarReserva;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import com.ceiba.restaurant.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")

public class ServicioValidarReservaTest {

    private static final String LA_MESA_NO_EXISTE = "La mesa no existe";
    private static final LocalTime HORA_INICIO = LocalTime.parse("18:01");
    private static final LocalTime HORA_FINAL = LocalTime.parse("20:01");
    private static final LocalDate FECHA = LocalDate.parse("2021-01-01");

    @Test
     public void validarMesaExisteTest(){
        //arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        Mesa mesa = new MesaTestDataBuilder().build();

        RepositorioReserva repositorioReserva = mock(RepositorioReserva.class);
        RepositorioMesa repositorioMesa = mock(RepositorioMesa.class);
        when(repositorioMesa.obtenerPorNumero(mesa.getNumeroMesa())).thenReturn(null);
        ServicioValidarReserva servicioValidarReserva = new ServicioValidarReserva(repositorioReserva,repositorioMesa);
        //act
        try {
            servicioValidarReserva.ejecutar(reserva);
        }catch(ExcepcionMesaInexistente e){
            //assert
            Assertions.assertEquals(LA_MESA_NO_EXISTE,e.getMessage());
        }
    }

    @Test
    public void validarDisponibilidadTest(){
        //arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        Mesa mesa = new MesaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = mock(RepositorioReserva.class);
        RepositorioMesa repositorioMesa = mock(RepositorioMesa.class);
        reserva.setFecha(FECHA);
        reserva.setHoraInicio(HORA_INICIO);
        reserva.setHoraFinal(HORA_FINAL);
        when(repositorioMesa.obtenerPorNumero(mesa.getNumeroMesa())).thenReturn(mesa);
        ServicioValidarReserva servicioValidarReserva = new ServicioValidarReserva(repositorioReserva,repositorioMesa);
        //act
        boolean respuesta = servicioValidarReserva.ejecutar(reserva);
            //assert
        Assertions.assertFalse(respuesta);
    }



}

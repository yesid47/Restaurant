package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.dto.DtoMesa;
import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaInexistente;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaReservada;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionPersonaInexistente;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import com.ceiba.restaurant.dominio.servicio.reserva.ServicioCrearReserva;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.restaurant.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.Assert.fail;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioCrearReservaTest {

    private static final String LA_MESA_ESTA_OCUPADA = "La mesa que seleccionó ya tiene una reserva a esa hora";
    private static final String LA_MESA_NO_EXISTE = "La mesa no existe";
    private static final String LA_PERSONA_NO_EXISTE = "La persona no existe";
    private static final LocalTime HORA_INICIO = LocalTime.parse("10:40");
    private static final LocalTime HORA_FINAL = LocalTime.parse("10:40");
    private static final LocalDate FECHA = LocalDate.parse("2020-12-31");



    @Test
    public void validarDisponibilidadTest(){
       //arrange
        RepositorioMesa repositorioMesa = mock(RepositorioMesa.class);
        DtoMesa mesa = new MesaTestDataBuilder().buildDto();
        when(repositorioMesa.obtenerPorNumero(mesa.getNumeroMesa())).thenReturn(mesa);
        RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);
        DtoPersona persona = new PersonaTestDataBuilder().buildDto();
        when(repositorioPersona.obtenerPorCedula(persona.getCedula())).thenReturn(persona);
        RepositorioReserva repositorioReserva = mock(RepositorioReserva.class);
        Reserva reserva = new ReservaTestDataBuilder().build();
        reserva.setHoraInicio(HORA_INICIO);
        reserva.setHoraFinal(HORA_FINAL);
        reserva.setFecha(FECHA);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioMesa,repositorioPersona);
        try {
            servicioCrearReserva.ejecutar(reserva);
        }catch(ExcepcionMesaReservada e){
            Assertions.assertEquals(LA_MESA_ESTA_OCUPADA, e.getMessage());
        }
    }

   @Test
    public void validarMesaInexistenteTest(){
        //arrange
        RepositorioMesa repositorioMesa = mock(RepositorioMesa.class);
        DtoMesa mesa = new MesaTestDataBuilder().buildDto();
        when(repositorioMesa.obtenerPorNumero(mesa.getNumeroMesa())).thenReturn(null);
        RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);
        DtoPersona persona = new PersonaTestDataBuilder().buildDto();
        when(repositorioPersona.obtenerPorCedula(persona.getCedula())).thenReturn(persona);
        RepositorioReserva repositorioReserva = mock(RepositorioReserva.class);
        Reserva reserva = new ReservaTestDataBuilder().build();
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioMesa,repositorioPersona);

        //act
        try {
            servicioCrearReserva.ejecutar(reserva);
            fail();
        }catch(ExcepcionMesaInexistente e){
            Assertions.assertEquals(LA_MESA_NO_EXISTE, e.getMessage());
        }
    }


   @Test
    public void validarPersonaInexistenteTest(){
        //arrange
        RepositorioMesa repositorioMesa = mock(RepositorioMesa.class);
        DtoMesa mesa = new MesaTestDataBuilder().buildDto();
        when(repositorioMesa.obtenerPorNumero(mesa.getNumeroMesa())).thenReturn(mesa);
        RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);
        Persona persona = new PersonaTestDataBuilder().build();
        when(repositorioPersona.obtenerPorCedula(persona.getCedula())).thenReturn(null);
        RepositorioReserva repositorioReserva = mock(RepositorioReserva.class);
        Reserva reserva = new ReservaTestDataBuilder().build();
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioMesa,repositorioPersona);

        try {
            servicioCrearReserva.ejecutar(reserva);
            fail();
        }catch(ExcepcionPersonaInexistente e){
            Assertions.assertEquals(LA_PERSONA_NO_EXISTE, e.getMessage());
        }
    }

}

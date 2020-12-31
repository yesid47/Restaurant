package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.ValidadorArgumento;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class ReservaTest {

    private static final LocalTime horaInicial = LocalTime.parse("10:20");
    private static final LocalDate fechaJueves = LocalDate.parse("2021-01-07");
    private static final LocalDate fechaDomingo = LocalDate.parse("2021-01-03");
    private static final double precioMesa = 20000;

    private Reserva reserva;
    private Persona persona;
    private Mesa mesa;

    private ValidadorArgumento validadorArgumento;

    @BeforeEach
    public void inicializarReserva(){
        mesa = new MesaTestDataBuilder().build();
        persona = new PersonaTestDataBuilder().build();
        reserva= new Reserva(1,fechaJueves,horaInicial,persona,mesa);
        //MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calcularHoraFinalTest(){
        //arrange
        //act
        LocalTime horaFinal = this.reserva.calcularHoraFinal(horaInicial);
        LocalTime horaEsperada = LocalTime.parse("12:20");
        //assert
        assertEquals(horaEsperada,horaFinal);
    }

    @Test
    public void calcularSiEsJuevesTest(){
        //arrange
        //act
        boolean valor = this.reserva.calcularSiEsJueves(fechaJueves);
        //assert
        assertTrue(valor);
    }

    @Test
    public void calcularSiEsDomingoTest(){
        //arrange
        //act
        boolean valor = this.reserva.calcularSiEsDomingo(fechaDomingo);
        //assert
        assertTrue(valor);
    }

   @Test
    public void calcularValorAPagarDomingo(){
        //arrange
        //act
        double valorAPagar = this.reserva.calcularValorApagar(precioMesa, fechaDomingo);
        double valorEsperado= 40000;
        //assert
       assertEquals(valorEsperado,valorAPagar,0.0);

    }

    @Test
    public void calcularValorAPagarJueves(){
        //arrange
        //act
        double valorAPagar = this.reserva.calcularValorApagar(precioMesa, fechaJueves);
        double valorEsperado= 10000;
        //assert
        assertEquals(valorEsperado,valorAPagar,0.0);

    }
}

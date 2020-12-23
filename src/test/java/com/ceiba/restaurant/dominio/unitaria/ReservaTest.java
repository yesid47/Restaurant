package com.ceiba.restaurant.dominio.unitaria;


import com.ceiba.restaurant.dominio.Reserva;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class ReservaTest {

    private static final LocalTime horaInicial = LocalTime.parse("10:20");

    @Test
    public void calcularHoraFinalTest(){
        //arrange
        Reserva reserva = new Reserva();
        //act
        LocalTime horaFinal = reserva.calcularHoraFinal(horaInicial);
        LocalTime horaEsperada = LocalTime.parse("12:20");
        //assert
        assertEquals(horaEsperada,horaFinal);
    }
}

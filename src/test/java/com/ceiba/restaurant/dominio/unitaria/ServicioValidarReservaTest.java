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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioValidarReservaTest {

    private static final String LA_MESA_NO_EXISTE = "La mesa no existe";

    @Test
     public void validarNoDisponibilidadTest(){
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


}

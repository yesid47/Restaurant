package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.excepcion.ExcepcionReservaNoExiste;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import com.ceiba.restaurant.dominio.servicio.reserva.ServicioEliminarReserva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioEliminarReservaTest {

    private static final String LA_RESERVA_NO_EXISTE = "La reserva no existe";

    @Test
    public void reservaNoExisteTest(){
        //arrange
        RepositorioReserva repositorioReserva = mock(RepositorioReserva.class);
        long idInexistente = 0;
        when(repositorioReserva.obtenerPorId(idInexistente)).thenReturn(null);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        try {
            //act
            servicioEliminarReserva.ejecutar(idInexistente);
        }catch(ExcepcionReservaNoExiste e){
            //assert
            Assertions.assertEquals(LA_RESERVA_NO_EXISTE,e.getMessage());
        }
    }
}

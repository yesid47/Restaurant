package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComandoMesaTest {

    @Test
    public void comandoMesaTest(){
        //arrange
        ComandoMesa comandoMesaEsperada = new MesaTestDataBuilder().buildComando();
        //act
        ComandoMesa comandoMesa = new ComandoMesa(comandoMesaEsperada.getCapacidadPersonas(),comandoMesaEsperada.getNumeroMesa(), comandoMesaEsperada.getPrecio());
        //assert
        Assertions.assertEquals(comandoMesaEsperada.getNumeroMesa(),comandoMesa.getNumeroMesa());
        Assertions.assertEquals(comandoMesaEsperada.getCapacidadPersonas(),comandoMesa.getCapacidadPersonas());
        Assertions.assertEquals(comandoMesaEsperada.getPrecio(),comandoMesa.getPrecio());
    }
}

package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaMesa;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FabricaMesaTest {

        @Test
        public void crearTest(){

                //arrange
                FabricaMesa fabricaMesa = new FabricaMesa();
                ComandoMesa comandoMesa = new MesaTestDataBuilder().buildComando();
                Mesa mesaEsperada = new MesaTestDataBuilder().build();
                //act
                Mesa mesa = fabricaMesa.crear(comandoMesa);
                //assert
                Assertions.assertEquals(mesaEsperada.getNumeroMesa(),mesa.getNumeroMesa());
                Assertions.assertEquals(mesaEsperada.getCapacidadPersonas(),mesa.getCapacidadPersonas());
                Assertions.assertEquals(mesaEsperada.getPrecio(),mesa.getPrecio());
        }
}

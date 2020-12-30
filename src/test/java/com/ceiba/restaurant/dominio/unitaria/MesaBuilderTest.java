package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.infraestructura.persistencia.builder.MesaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MesaBuilderTest {
    @Test
    public void convertirADominioTest(){
        //arrange
        MesaEntity mesaEntity = new MesaTestDataBuilder().buildEntity();
        Mesa mesaEsperada = new MesaTestDataBuilder().build();
        //act
        Mesa mesa = MesaBuilder.convertirADominio(mesaEntity);
        //assert
        Assertions.assertEquals(mesaEsperada.getIdMesa(),mesa.getIdMesa());
        Assertions.assertEquals(mesaEsperada.getCapacidadPersonas(),mesa.getCapacidadPersonas());
        Assertions.assertEquals(mesaEsperada.getNumeroMesa(),mesa.getNumeroMesa());
        Assertions.assertEquals(mesaEsperada.getPrecio(),mesa.getPrecio(),0.0);
    }

    @Test
    public void convertirAEntityTest(){
        //arrange
        MesaEntity mesaEntityEsperada = new MesaTestDataBuilder().buildEntity();
        Mesa mesa = new MesaTestDataBuilder().build();
        //act
        MesaEntity mesaEntity = MesaBuilder.convertirAEntity(mesa);
        //assert
        Assertions.assertEquals(mesaEntityEsperada.getId(),mesaEntity.getId());
        Assertions.assertEquals(mesaEntityEsperada.getCapacidad(),mesaEntity.getCapacidad());
        Assertions.assertEquals(mesaEntityEsperada.getNumeroMesa(),mesaEntity.getNumeroMesa());
        Assertions.assertEquals(mesaEntityEsperada.getPrecio(),mesaEntity.getPrecio(),0.0);
    }

}
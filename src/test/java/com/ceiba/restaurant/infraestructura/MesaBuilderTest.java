package com.ceiba.restaurant.infraestructura;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.infraestructura.persistencia.builder.MesaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.builder.PersonaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void convertirADominioNullTest(){
        //arrange
        MesaEntity mesaEntity = null;
        Mesa mesaEsperada = null;
        //act
        Mesa mesa = MesaBuilder.convertirADominio(mesaEntity);
        //assert
        Assertions.assertEquals(mesaEsperada,mesa);
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

    @Test
    public void convertirADominioListTest(){
        //arrange
        MesaEntity mesaEntity= new MesaTestDataBuilder().buildEntity();
        ArrayList<MesaEntity> listaEntities= new ArrayList<>();
        listaEntities.add(mesaEntity);
        //act
        List<Mesa> mesas = MesaBuilder.convertirADominio(listaEntities);
        //assert
        Assertions.assertNotNull(mesas.get(0));
    }

}
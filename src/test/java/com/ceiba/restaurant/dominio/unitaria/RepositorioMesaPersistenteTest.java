package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.infraestructura.persistencia.repositorio.RepositorioMesaPersistente;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@DataJpaTest
//@WebMvcTest(RepositorioMesa.class)
//@TestPropertySource(locations = "classpath:test.properties")
/*public class RepositorioMesaPersistenteTest {

    @Autowired
    private RepositorioMesaPersistente repositorioMesa;

    @Test
    @Rollback(false)
    public void agregarTest(){
        //arrange
        Mesa mesa = new MesaTestDataBuilder().build();
        //act
        repositorioMesa.agregar(mesa);
        //assert
        Assertions.assertNotNull(repositorioMesa.obtenerPorId(mesa.getIdMesa()));
    }
}*/

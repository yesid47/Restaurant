package com.ceiba.restaurant.aplicacion;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaPersona;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FabricaPersonaTest {

    @Test
    public void crearTest(){
        //arrange
        FabricaPersona fabricaPersona = new FabricaPersona();
        ComandoPersona comandoPersona = new PersonaTestDataBuilder().buildComando();
        Persona personaEsperada = new PersonaTestDataBuilder().build();
        //act
        Persona persona = fabricaPersona.crear(comandoPersona);
        //assert
        Assertions.assertEquals(personaEsperada.getNombrePersona(),persona.getNombrePersona());
        Assertions.assertEquals(personaEsperada.getCedula(),persona.getCedula());
        Assertions.assertEquals(personaEsperada.getCelular(),persona.getCelular());
        Assertions.assertEquals(personaEsperada.getEmail(),persona.getEmail());
        Assertions.assertEquals(personaEsperada.getDireccion(),persona.getDireccion());
    }
}

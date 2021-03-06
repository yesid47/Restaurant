package com.ceiba.restaurant.aplicacion;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComandoPersonaTest {

    @Test
    public void comandoPersonaTest(){
        //arrange
        ComandoPersona comandoPersonaEsperada = new PersonaTestDataBuilder().buildComando();
        //act
        ComandoPersona comandoPersona = new ComandoPersona(comandoPersonaEsperada.getNombre(), comandoPersonaEsperada.getCedula(), comandoPersonaEsperada.getCelular(), comandoPersonaEsperada.getEmail(), comandoPersonaEsperada.getDireccion());
        //assert
        Assertions.assertEquals(comandoPersonaEsperada.getNombre(),comandoPersona.getNombre());
        Assertions.assertEquals(comandoPersonaEsperada.getCedula(),comandoPersona.getCedula());
        Assertions.assertEquals(comandoPersonaEsperada.getCelular(),comandoPersona.getCelular());
        Assertions.assertEquals(comandoPersonaEsperada.getEmail(),comandoPersona.getEmail());
        Assertions.assertEquals(comandoPersonaEsperada.getDireccion(),comandoPersona.getDireccion());

    }
}

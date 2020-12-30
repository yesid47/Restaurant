package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.infraestructura.persistencia.builder.PersonaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.PersonaEntity;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonaBuilderTest {

    @Test
    public void convertirADominioTest(){
        //arrange
        PersonaEntity personaEntity = new PersonaTestDataBuilder().buildEntity();
        Persona personaEsperada = new PersonaTestDataBuilder().build();
        //act
        Persona persona = PersonaBuilder.convertirADominio(personaEntity);
        //assert
        Assertions.assertEquals(personaEsperada.getNombrePersona(),persona.getNombrePersona());
        Assertions.assertEquals(personaEsperada.getIdPersona(),persona.getIdPersona());
        Assertions.assertEquals(personaEsperada.getCedula(),persona.getCedula());
        Assertions.assertEquals(personaEsperada.getCelular(),persona.getCelular());
        Assertions.assertEquals(personaEsperada.getEmail(),persona.getEmail());
        Assertions.assertEquals(personaEsperada.getDireccion(),persona.getDireccion());
    }


    @Test
    public void convertirAEntityTest(){
        //arrange
        PersonaEntity personaEntityEsperada = new PersonaTestDataBuilder().buildEntity();
        Persona persona = new PersonaTestDataBuilder().build();
        //act
        PersonaEntity personaEntity = PersonaBuilder.convertirAEntity(persona);
        //assert
        Assertions.assertEquals(personaEntityEsperada.getNombre(),personaEntity.getNombre());
        Assertions.assertEquals(personaEntityEsperada.getId(),personaEntity.getId());
        Assertions.assertEquals(personaEntityEsperada.getCedula(),personaEntity.getCedula());
        Assertions.assertEquals(personaEntityEsperada.getCelular(),personaEntity.getCelular());
        Assertions.assertEquals(personaEntityEsperada.getEmail(),persona.getEmail());
        Assertions.assertEquals(personaEntityEsperada.getDireccion(),personaEntity.getDireccion());
    }
}

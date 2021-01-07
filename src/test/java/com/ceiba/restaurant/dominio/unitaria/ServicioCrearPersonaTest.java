package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionPersonaExiste;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import com.ceiba.restaurant.dominio.servicio.persona.ServicioCrearPersona;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.fail;

public class ServicioCrearPersonaTest {

    private static final String LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA = "La persona ya existe en el sistema";

  @Test
    public void personaExisteTest(){
        RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);
        Persona persona = new PersonaTestDataBuilder().build();
        DtoPersona personaDto = new PersonaTestDataBuilder().buildDto();
        when(repositorioPersona.obtenerPorCedula(persona.getCedula())).thenReturn(personaDto);
        ServicioCrearPersona servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        //act
        try {
            servicioCrearPersona.ejecutar(persona);
            fail();
        }catch(ExcepcionPersonaExiste e)
        {
            Assertions.assertEquals(LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA,e.getMessage());
        }
    }

}

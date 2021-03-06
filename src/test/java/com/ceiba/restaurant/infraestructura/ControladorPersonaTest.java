package com.ceiba.restaurant.infraestructura;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.testdatabuilder.PersonaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@AutoConfigureMockMvc
public class ControladorPersonaTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void agregarPersonaTest() throws Exception
    {
        ComandoPersona comandoPersona = new PersonaTestDataBuilder().buildComando();
        comandoPersona.setCedula("3603389");
        mvc.perform( MockMvcRequestBuilders
                .post("/persona")
                .content(objectMapper.writeValueAsString(comandoPersona))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void getPersonaPorCedulaTest() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/persona/{cedula}", "1045044024")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idPersona").value(20));
    }

    @Test
    public void getPersonaPorIdTest() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/persona/id/{id}", 20)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idPersona").value(20));
    }

    @Test
    public void listarPersonasTest() throws Exception
    {

        mvc.perform( MockMvcRequestBuilders
                .get("/persona/personas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].nombre").value("Michael Martinez"));
    }


    @Test
    public void deletePersonaPorIdTest() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .delete("/persona/{id}", 30)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void actualizarPersonaTest() throws Exception
    {
        ComandoPersona comandoPersona = new PersonaTestDataBuilder().buildComando();
        mvc.perform( MockMvcRequestBuilders
                .put("/persona/{id}",10)
                .content(objectMapper.writeValueAsString(comandoPersona))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}

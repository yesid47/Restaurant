package com.ceiba.restaurant.infraestructura;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorMesaTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void agregarMesaTest() throws Exception
    {
        ComandoMesa comandoMesa = new MesaTestDataBuilder().buildComando();
        mvc.perform( MockMvcRequestBuilders
                .post("/mesa")
                .content(objectMapper.writeValueAsString(comandoMesa))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void getMesaPorIdTest() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/mesa/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idMesa").value(1));
    }

   /* @Test
    public void listarMesasTest() throws Exception
    {

        mvc.perform( MockMvcRequestBuilders
                .get("/mesa/mesas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/
}

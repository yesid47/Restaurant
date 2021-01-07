package com.ceiba.restaurant.infraestructura;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.testdatabuilder.ReservaTestDataBuilder;
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
public class ControladorReservaTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void agregarReservaTest() throws Exception
    {

        ComandoReserva comandoReserva = new ReservaTestDataBuilder().buildComando();
        comandoReserva.getPersona().setCedula("1045044024");
        comandoReserva.getMesa().setNumeroMesa(40);
        mvc.perform( MockMvcRequestBuilders
                .post("/reserva")
                .content(objectMapper.writeValueAsString(comandoReserva))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void listarReservasTest() throws Exception
    {

        mvc.perform( MockMvcRequestBuilders
                .get("/reserva/reservas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].valorAPagar").value(70000));
    }

    @Test
    public void deleteReservaTest() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .delete("/reserva/{id}", 30)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void actualizarEstadosTest() throws Exception
    {

        mvc.perform( MockMvcRequestBuilders
                .get("/reserva/actualizarEstados")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void validarReservaTest() throws Exception
    {
        ComandoReserva comandoReserva = new ReservaTestDataBuilder().buildComando();
        comandoReserva.getPersona().setCedula("1045044024");
        comandoReserva.getMesa().setNumeroMesa(20);
        mvc.perform( MockMvcRequestBuilders
                .post("/reserva")
                .content(objectMapper.writeValueAsString(comandoReserva))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }





}

package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.dto.DtoMesa;
import com.ceiba.restaurant.dominio.dto.DtoPersona;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaInexistente;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaReservada;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionPersonaInexistente;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearReserva {


    private static final String LA_MESA_ESTA_OCUPADA = "La mesa que seleccionó ya tiene una reserva a esa hora";
    private static final String LA_MESA_NO_EXISTE = "La mesa no existe";
    private static final String LA_PERSONA_NO_EXISTE = "La persona no existe";

    private final RepositorioReserva repositorioReserva;
    private final RepositorioMesa repositorioMesa;
    private final RepositorioPersona repositorioPersona;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioMesa repositorioMesa, RepositorioPersona repositorioPersona){
        this.repositorioReserva = repositorioReserva;
        this.repositorioMesa = repositorioMesa;
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Reserva reserva){

        DtoMesa mesa = this.repositorioMesa.obtenerPorNumero(reserva.getMesa().getNumeroMesa());
        DtoPersona persona = this.repositorioPersona.obtenerPorCedula(reserva.getPersona().getCedula());


        validarMesaExistente(mesa);
        validarPersonaExistente(persona);
        reserva.getMesa().setIdMesa(mesa.getIdMesa());
        reserva.getPersona().setIdPersona(persona.getIdPersona());
        validarDisponibilidad(reserva,reserva.getMesa());

        this.repositorioReserva.agregar(reserva);

    }

    private void validarDisponibilidad(Reserva reserva, Mesa mesa){
        if(this.repositorioReserva.validarDisponibilidad(reserva.getFecha(),reserva.getHoraInicio(),reserva.getHoraFinal(),mesa)){
            throw new ExcepcionMesaReservada(LA_MESA_ESTA_OCUPADA);
        }
    }

    private void validarMesaExistente(DtoMesa mesa){
        if(mesa == null){
            throw new ExcepcionMesaInexistente(LA_MESA_NO_EXISTE);
        }
    }

    private void validarPersonaExistente(DtoPersona persona){
        if(persona == null){
            throw new ExcepcionPersonaInexistente(LA_PERSONA_NO_EXISTE);
        }
    }

}

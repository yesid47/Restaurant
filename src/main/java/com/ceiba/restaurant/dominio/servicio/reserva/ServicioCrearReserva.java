package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaInexistente;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaReservada;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionPersonaInexistente;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import com.ceiba.restaurant.dominio.servicio.mesa.ServicioBuscarMesa;
import com.ceiba.restaurant.dominio.servicio.persona.ServicioBuscarPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearReserva {


    private static final String LA_MESA_ESTA_OCUPADA = "La mesa que seleccionó ya tiene una reserva a esa hora";
    private static final String LA_MESA_NO_EXISTE = "La mesa no existe";
    private static final String LA_PERSONA_NO_EXISTE = "La persona no existe";

    private RepositorioReserva repositorioReserva;
    private ServicioBuscarMesa servicioBuscarMesa;
    private ServicioBuscarPersona servicioBuscarPersona;

    public ServicioCrearReserva(RepositorioReserva repositorioReservaPersistente, ServicioBuscarPersona servicioBuscarPersona, ServicioBuscarMesa servicioBuscarMesa){
        this.repositorioReserva = repositorioReservaPersistente;
        this.servicioBuscarMesa = servicioBuscarMesa;
        this.servicioBuscarPersona = servicioBuscarPersona;

    }

    public void ejecutar(Reserva reserva){

        Mesa mesa = this.servicioBuscarMesa.ejecutar(reserva.getMesa().getNumeroMesa());
        Persona persona = this.servicioBuscarPersona.ejecutar(reserva.getPersona().getCedula());

        validarMesaExistente(mesa);
        validarPersonaExistente(persona);
        validarDisponibilidad(reserva,mesa);

        reserva.setMesa(mesa);
        reserva.setPersona(persona);
        this.repositorioReserva.agregar(reserva);

    }

    public void validarDisponibilidad(Reserva reserva, Mesa mesa){
        if(this.repositorioReserva.validarDisponibilidad(reserva.getFecha(),reserva.getHoraInicio(),reserva.getHoraFinal(),mesa)){
            throw new ExcepcionMesaReservada(LA_MESA_ESTA_OCUPADA);
        }
    }

    public void validarMesaExistente(Mesa mesa){
        if(mesa == null){
            throw new ExcepcionMesaInexistente(LA_MESA_NO_EXISTE);
        }
    }

    public void validarPersonaExistente(Persona persona){
        if(persona == null){
            throw new ExcepcionPersonaInexistente(LA_PERSONA_NO_EXISTE);
        }
    }

}

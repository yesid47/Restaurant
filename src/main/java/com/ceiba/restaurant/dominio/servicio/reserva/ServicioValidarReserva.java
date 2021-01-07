package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.dto.DtoMesa;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaInexistente;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

@Component
public class ServicioValidarReserva {

    private final RepositorioReserva repositorioReserva;
    private final RepositorioMesa repositorioMesa;

    private static final String LA_MESA_NO_EXISTE = "La mesa no existe";

    public ServicioValidarReserva(RepositorioReserva repositorioReserva, RepositorioMesa repositorioMesa){
        this.repositorioReserva = repositorioReserva;

        this.repositorioMesa = repositorioMesa;
    }

    public boolean ejecutar(Reserva reserva){

        DtoMesa mesa = this.repositorioMesa.obtenerPorNumero(reserva.getMesa().getNumeroMesa());
        validarMesaExistente(mesa);
        reserva.getMesa().setIdMesa(mesa.getIdMesa());

        return this.repositorioReserva.validarDisponibilidad(reserva.getFecha(),reserva.getHoraInicio(),reserva.getHoraFinal(),reserva.getMesa());
    }

    private void validarMesaExistente(DtoMesa mesa){
        if(mesa == null){
            throw new ExcepcionMesaInexistente(LA_MESA_NO_EXISTE);
        }
    }
}

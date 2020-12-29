package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaInexistente;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import com.ceiba.restaurant.dominio.servicio.mesa.ServicioBuscarMesa;
import org.springframework.stereotype.Component;

@Component
public class ServicioValidarReserva {
    private RepositorioReserva repositorioReserva;
    private static final String LA_MESA_NO_EXISTE = "La mesa no existe";
    private ServicioBuscarMesa servicioBuscarMesa;

    public ServicioValidarReserva(RepositorioReserva repositorioReserva, ServicioBuscarMesa servicioBuscarMesa){
        this.repositorioReserva = repositorioReserva;
        this.servicioBuscarMesa = servicioBuscarMesa;

    }

    public boolean ejecutar(Reserva reserva){

        Mesa mesa = this.servicioBuscarMesa.ejecutar(reserva.getMesa().getNumeroMesa());
        validarMesaExistente(mesa);

        return this.repositorioReserva.validarDisponibilidad(reserva.getFecha(),reserva.getHoraInicio(),reserva.getHoraFinal(),mesa);
    }

    public void validarMesaExistente(Mesa mesa){
        if(mesa == null){
            throw new ExcepcionMesaInexistente(LA_MESA_NO_EXISTE);
        }
    }
}

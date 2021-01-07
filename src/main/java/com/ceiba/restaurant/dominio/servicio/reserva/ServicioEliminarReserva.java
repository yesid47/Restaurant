package com.ceiba.restaurant.dominio.servicio.reserva;

import com.ceiba.restaurant.dominio.excepcion.ExcepcionReservaNoExiste;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

@Component
public class ServicioEliminarReserva {

    private final RepositorioReserva repositorioReserva;

    private static final String LA_RESERVA_NO_EXISTE = "La reserva no existe";

    public ServicioEliminarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(long id){
        validarReservaExiste(id);
        this.repositorioReserva.eliminar(id);
    }

    private void validarReservaExiste(long id){
        if(this.repositorioReserva.obtenerPorId(id)==null){
            throw new ExcepcionReservaNoExiste(LA_RESERVA_NO_EXISTE);
        }
    }
}

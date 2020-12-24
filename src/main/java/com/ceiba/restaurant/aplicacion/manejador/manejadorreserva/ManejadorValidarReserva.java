package com.ceiba.restaurant.aplicacion.manejador.manejadorreserva;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaReserva;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.servicio.mesa.ServicioBuscarMesa;
import com.ceiba.restaurant.dominio.servicio.persona.ServicioBuscarPersona;
import com.ceiba.restaurant.dominio.servicio.reserva.ServicioValidarReserva;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorValidarReserva {
    private final ServicioValidarReserva servicioValidarReserva;
    private final ServicioBuscarPersona servicioBuscarPersona;
    private final ServicioBuscarMesa servicioBuscarMesa;
    private final FabricaReserva fabricaReserva;

    public ManejadorValidarReserva(ServicioValidarReserva servicioValidarReserva, FabricaReserva fabricaReserva, ServicioBuscarMesa servicioBuscarMesa,
                                 ServicioBuscarPersona servicioBuscarPersona)
    {
        this.servicioValidarReserva = servicioValidarReserva;
        this.fabricaReserva= fabricaReserva;
        this.servicioBuscarPersona = servicioBuscarPersona;
        this.servicioBuscarMesa = servicioBuscarMesa;
    }

    @Transactional
    public boolean ejecutar(ComandoReserva comandoReserva){
        Persona persona = this.servicioBuscarPersona.ejecutar(comandoReserva.getPersona());
        Mesa mesa = this.servicioBuscarMesa.ejecutar(comandoReserva.getMesa());
        Reserva reserva = this.fabricaReserva.crear(comandoReserva, persona, mesa);
        return this.servicioValidarReserva.ejecutar(reserva);
    }
}

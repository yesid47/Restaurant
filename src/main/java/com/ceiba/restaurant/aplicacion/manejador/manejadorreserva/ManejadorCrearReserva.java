package com.ceiba.restaurant.aplicacion.manejador.manejadorreserva;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaReserva;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.servicio.mesa.ServicioBuscarMesa;
import com.ceiba.restaurant.dominio.servicio.persona.ServicioBuscarPersona;
import com.ceiba.restaurant.dominio.servicio.reserva.ServicioCrearReserva;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearReserva {

    private final ServicioCrearReserva servicioCrearReserva;
    private final ServicioBuscarPersona servicioBuscarPersona;
    private final ServicioBuscarMesa servicioBuscarMesa;
    private final FabricaReserva fabricaReserva;

    public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva, FabricaReserva fabricaReserva, ServicioBuscarMesa servicioBuscarMesa,
                                 ServicioBuscarPersona servicioBuscarPersona)
    {
        this.servicioCrearReserva = servicioCrearReserva;
        this.fabricaReserva= fabricaReserva;
        this.servicioBuscarPersona = servicioBuscarPersona;
        this.servicioBuscarMesa = servicioBuscarMesa;
    }

    @Transactional
    public void ejecutar(ComandoReserva comandoReserva){
        Persona persona = this.servicioBuscarPersona.ejecutar(comandoReserva.getPersona());
        Mesa mesa = this.servicioBuscarMesa.ejecutar(comandoReserva.getMesa());
        Reserva reserva = this.fabricaReserva.crear(comandoReserva, persona, mesa);
        this.servicioCrearReserva.ejecutar(reserva);
    }
}

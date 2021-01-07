package com.ceiba.restaurant.aplicacion.manejador.reserva;

import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.servicio.reserva.ServicioListarReservas;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ManejadorListarReservas {

    private ServicioListarReservas servicioListarReservas;

    public ManejadorListarReservas(ServicioListarReservas servicioListarReservas) {
        this.servicioListarReservas = servicioListarReservas;
    }

    @Transactional
    public List<Reserva> ejecutar(){
        return servicioListarReservas.ejecutar();
    }
}

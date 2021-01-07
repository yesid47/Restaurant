package com.ceiba.restaurant.aplicacion.manejador.mesa;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.servicio.mesa.ServicioListarMesas;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ManejadorListarMesas {
    private final ServicioListarMesas servicioListarMesas;

    public ManejadorListarMesas(ServicioListarMesas servicioListarMesas)
    {
        this.servicioListarMesas = servicioListarMesas;
    }

    @Transactional
    public List<Mesa> ejecutar(){
        return this.servicioListarMesas.ejecutar();
    }
}

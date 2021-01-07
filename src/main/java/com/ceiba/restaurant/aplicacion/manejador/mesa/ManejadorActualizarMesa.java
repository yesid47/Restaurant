package com.ceiba.restaurant.aplicacion.manejador.mesa;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaMesa;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.servicio.mesa.ServicioActualizarMesa;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarMesa {

    private final ServicioActualizarMesa servicioActualizarMesa;
    private final FabricaMesa fabricaMesa;

    public ManejadorActualizarMesa(ServicioActualizarMesa servicioActualizarMesa, FabricaMesa fabricaMesa)
    {
        this.servicioActualizarMesa = servicioActualizarMesa;
        this.fabricaMesa= fabricaMesa;
    }

    @Transactional
    public void ejecutar(ComandoMesa comandoMesa){
        Mesa mesa = this.fabricaMesa.crear(comandoMesa);
        this.servicioActualizarMesa.ejecutar(mesa);
    }
}

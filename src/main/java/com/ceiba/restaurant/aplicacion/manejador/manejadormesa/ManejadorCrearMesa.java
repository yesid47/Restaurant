package com.ceiba.restaurant.aplicacion.manejador.manejadormesa;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.aplicacion.fabrica.FabricaMesa;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.servicio.mesa.ServicioCrearMesa;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearMesa {

    private final ServicioCrearMesa servicioCrearMesa;
    private final FabricaMesa fabricaMesa;

    public ManejadorCrearMesa(ServicioCrearMesa servicioCrearMesa, FabricaMesa fabricaMesa)
    {
        this.servicioCrearMesa = servicioCrearMesa;
        this.fabricaMesa= fabricaMesa;
    }

    @Transactional
    public void ejecutar(ComandoMesa comandoMesa){
        Mesa mesa = this.fabricaMesa.crear(comandoMesa);
        this.servicioCrearMesa.ejecutar(mesa);
    }
}

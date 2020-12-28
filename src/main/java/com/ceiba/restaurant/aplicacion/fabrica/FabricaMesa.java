package com.ceiba.restaurant.aplicacion.fabrica;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.dominio.Mesa;
import org.springframework.stereotype.Component;

@Component
public class FabricaMesa {

    public Mesa crear(ComandoMesa comandoMesa){
        return new Mesa(comandoMesa.getIdMesa(),comandoMesa.getCapacidadPersonas(),comandoMesa.getNumeroMesa(), comandoMesa.getPrecio());
    }
}

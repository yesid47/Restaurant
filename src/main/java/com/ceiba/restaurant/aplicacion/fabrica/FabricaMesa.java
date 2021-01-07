package com.ceiba.restaurant.aplicacion.fabrica;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.dominio.Mesa;
import org.springframework.stereotype.Component;

@Component
public class FabricaMesa {

    public Mesa crear(ComandoMesa comandoMesa){
        Mesa mesa= new Mesa(comandoMesa.getCapacidadPersonas(),comandoMesa.getNumeroMesa(), comandoMesa.getPrecio());
        mesa.setIdMesa(comandoMesa.getIdMesa());
        return mesa;
    }
}

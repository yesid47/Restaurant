package com.ceiba.restaurant.dominio.servicio.mesa;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import org.springframework.stereotype.Component;

@Component
public class ServicioActualizarMesa {

    private final RepositorioMesa repositorioMesa;

    public ServicioActualizarMesa(RepositorioMesa repositorioMesa) {
        this.repositorioMesa = repositorioMesa;
    }

    public void ejecutar(Mesa mesa){
        this.repositorioMesa.actualizar(mesa);
    }


}

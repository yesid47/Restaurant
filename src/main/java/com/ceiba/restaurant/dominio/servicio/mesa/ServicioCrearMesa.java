package com.ceiba.restaurant.dominio.servicio.mesa;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioCrearMesa {
    private RepositorioMesa repositorioMesa;

    public ServicioCrearMesa(RepositorioMesa repositorioMesa){
        this.repositorioMesa = repositorioMesa;
    }

    public void ejecutar(Mesa mesa){
        this.repositorioMesa.agregar(mesa);
    }
}

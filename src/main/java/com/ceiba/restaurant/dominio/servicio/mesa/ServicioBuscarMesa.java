package com.ceiba.restaurant.dominio.servicio.mesa;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioBuscarMesa {

    private RepositorioMesa repositorioMesa;

    public ServicioBuscarMesa(RepositorioMesa repositorioMesa){
        this.repositorioMesa = repositorioMesa;
    }

    public Mesa ejecutar(int id){
        return this.repositorioMesa.obtenerPorId(id);
    }
}

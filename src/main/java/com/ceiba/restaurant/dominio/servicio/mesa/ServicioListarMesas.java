package com.ceiba.restaurant.dominio.servicio.mesa;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarMesas {
    private RepositorioMesa repositorioMesa;

    public ServicioListarMesas(RepositorioMesa repositorioMesa){
        this.repositorioMesa = repositorioMesa;
    }

    public List<Mesa> ejecutar(){
        return this.repositorioMesa.listarMesas();
    }
}

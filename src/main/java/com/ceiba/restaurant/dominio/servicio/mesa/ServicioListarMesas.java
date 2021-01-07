package com.ceiba.restaurant.dominio.servicio.mesa;

import com.ceiba.restaurant.dominio.dto.DtoMesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarMesas {
    private final RepositorioMesa repositorioMesa;

    public ServicioListarMesas(RepositorioMesa repositorioMesa){
        this.repositorioMesa = repositorioMesa;
    }

    public List<DtoMesa> ejecutar(){
        return this.repositorioMesa.listarTodo();
    }
}

package com.ceiba.restaurant.dominio.servicio.mesa;

import com.ceiba.restaurant.dominio.dto.DtoMesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import org.springframework.stereotype.Component;

@Component
public class ServicioBuscarMesa {

    private final RepositorioMesa repositorioMesa;

    public ServicioBuscarMesa(RepositorioMesa repositorioMesa){
        this.repositorioMesa = repositorioMesa;
    }

    public DtoMesa ejecutar(int numero){
        return this.repositorioMesa.obtenerPorNumero(numero);
    }
}

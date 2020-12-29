package com.ceiba.restaurant.dominio.servicio.mesa;

import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import org.springframework.stereotype.Component;

@Component
public class ServicioEliminarMesa {

    private RepositorioMesa repositorioMesa;

    public ServicioEliminarMesa(RepositorioMesa repositorioMesa) {
        this.repositorioMesa = repositorioMesa;
    }

    public void ejecutar(int numero){
        this.repositorioMesa.eliminar(numero);
    }
}

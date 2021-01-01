package com.ceiba.restaurant.dominio.servicio.mesa;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaExiste;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import org.springframework.stereotype.Component;


@Component
public class ServicioCrearMesa {
    private final RepositorioMesa repositorioMesa;

    private static final String LA_MESA_YA_EXISTE_EN_EL_SISTEMA = "La mesa ya existe en el sistema";

    public ServicioCrearMesa(RepositorioMesa repositorioMesa){
        this.repositorioMesa = repositorioMesa;
    }

    public void ejecutar(Mesa mesa){
        validarExistenciaPrevia(mesa);
        this.repositorioMesa.agregar(mesa);
    }

    private void validarExistenciaPrevia(Mesa mesa){
        if (this.repositorioMesa.obtenerPorNumero(mesa.getNumeroMesa())!=null){
            throw new ExcepcionMesaExiste(LA_MESA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}

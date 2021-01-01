package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaExiste;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.dominio.servicio.mesa.ServicioCrearMesa;
import com.ceiba.restaurant.testdatabuilder.MesaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioCrearMesaTest {

    private static final String LA_MESA_YA_EXISTE_EN_EL_SISTEMA = "La mesa ya existe en el sistema";

    @Test
    public void mesaExisteTest(){
        RepositorioMesa repositorioMesa = mock(RepositorioMesa.class);
        Mesa mesa = new MesaTestDataBuilder().build();
        when(repositorioMesa.obtenerPorNumero(mesa.getNumeroMesa())).thenReturn(mesa);
        ServicioCrearMesa servicioCrearMesa = new ServicioCrearMesa(repositorioMesa);
        //act
        try {
            servicioCrearMesa.ejecutar(mesa);
            fail();
        }catch(ExcepcionMesaExiste e)
        {
            Assertions.assertEquals(LA_MESA_YA_EXISTE_EN_EL_SISTEMA,e.getMessage());
        }
    }
}

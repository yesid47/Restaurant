package com.ceiba.restaurant.infraestructura;

import com.ceiba.restaurant.dominio.excepcion.ExcepcionMesaExiste;
import com.ceiba.restaurant.infraestructura.excepcion.MyExcepcion;
import com.ceiba.restaurant.infraestructura.error.ManejadorError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class ManejadorErrorTest {

    private static final String mensaje= "Error la mesa ya existe en el sistema";

    @Test
     public void handleAllExceptionsTest(){
        //arrange
        ManejadorError manejadorError = new ManejadorError();
        Exception e = new MyExcepcion(500);
        //act
        ResponseEntity respuesta= manejadorError.handleAllExceptions(e);
        //assert
        Assertions.assertEquals(500,respuesta.getStatusCodeValue());
    }

    @Test
    public void handleAllExceptionsNotNullTest(){
        //arrange
        ManejadorError manejadorError = new ManejadorError();
        Exception e = new ExcepcionMesaExiste(mensaje);
        //act
        ResponseEntity respuesta= manejadorError.handleAllExceptions(e);
        //assert
        Assertions.assertEquals(500,respuesta.getStatusCodeValue());
    }
}

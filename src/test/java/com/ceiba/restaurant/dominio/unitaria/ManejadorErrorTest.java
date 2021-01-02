package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.dominio.unitaria.excepcion.MyExcepcion;
import com.ceiba.restaurant.infraestructura.error.ManejadorError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class ManejadorErrorTest {

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
}

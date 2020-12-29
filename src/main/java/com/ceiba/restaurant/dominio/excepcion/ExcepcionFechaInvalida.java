package com.ceiba.restaurant.dominio.excepcion;

public class ExcepcionFechaInvalida extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionFechaInvalida(String messaje){
        super(messaje);
    }
}

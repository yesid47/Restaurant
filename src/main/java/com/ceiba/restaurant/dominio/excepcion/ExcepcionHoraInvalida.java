package com.ceiba.restaurant.dominio.excepcion;

public class ExcepcionHoraInvalida extends RuntimeException{

    private static final long serialVersionUID = 1;

    public ExcepcionHoraInvalida(String message){
        super(message);
    }
}

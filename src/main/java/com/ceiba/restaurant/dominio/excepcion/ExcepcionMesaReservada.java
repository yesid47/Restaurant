package com.ceiba.restaurant.dominio.excepcion;

public class ExcepcionMesaReservada extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionMesaReservada(String message){
        super(message);
    }
}

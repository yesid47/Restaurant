package com.ceiba.restaurant.dominio.excepcion;

public class ExcepcionMesaExiste extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionMesaExiste(String message){
        super(message);
    }
}

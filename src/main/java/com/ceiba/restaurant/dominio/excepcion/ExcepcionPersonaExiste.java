package com.ceiba.restaurant.dominio.excepcion;

public class ExcepcionPersonaExiste extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionPersonaExiste(String message){
        super(message);
    }
}

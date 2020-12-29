package com.ceiba.restaurant.dominio.excepcion;

public class ExcepcionPersonaInexistente extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionPersonaInexistente(String message){
        super(message);
    }
}

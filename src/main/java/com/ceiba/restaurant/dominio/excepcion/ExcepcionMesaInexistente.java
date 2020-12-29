package com.ceiba.restaurant.dominio.excepcion;

public class ExcepcionMesaInexistente extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionMesaInexistente(String message){
        super(message);
    }
}

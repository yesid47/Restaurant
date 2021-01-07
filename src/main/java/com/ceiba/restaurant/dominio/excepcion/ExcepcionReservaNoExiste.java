package com.ceiba.restaurant.dominio.excepcion;

public class ExcepcionReservaNoExiste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionReservaNoExiste(String message) {
        super(message);
    }
}

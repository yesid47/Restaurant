package com.ceiba.restaurant.dominio.unitaria.excepcion;

public class MyExcepcion extends Exception {
    private int codigoError;

    public MyExcepcion(int codigoError){
        super();
        this.codigoError=codigoError;
    }

    @Override
    public String getMessage() {

        String mensaje = "Error";

        return mensaje;
    }
}

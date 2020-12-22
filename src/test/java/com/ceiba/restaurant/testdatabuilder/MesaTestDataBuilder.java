package com.ceiba.restaurant.testdatabuilder;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;

public class MesaTestDataBuilder {
    private static final int CAPACIDAD = 5;
    private static final int NUMEROMESA = 5;
    private static final double PRECIO = 20000;

    private int capacidad;
    private int numeroMesa;
    private double precio;

    public MesaTestDataBuilder(){
        this.capacidad = CAPACIDAD;
        this.numeroMesa = NUMEROMESA;
        this.precio = PRECIO;
    }

    public ComandoMesa buildComando(){
        return new ComandoMesa(capacidad,numeroMesa,precio);
    }
}

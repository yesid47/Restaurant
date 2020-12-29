package com.ceiba.restaurant.testdatabuilder;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.dominio.Mesa;

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

    public Mesa build(){
        return new Mesa(1,2,1,10000);
    }

    public ComandoMesa buildComando(){
        return new ComandoMesa(capacidad,numeroMesa,precio);
    }
}

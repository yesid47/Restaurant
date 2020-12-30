package com.ceiba.restaurant.testdatabuilder;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;

public class MesaTestDataBuilder {
    private static final int id = 1;
    private static final int CAPACIDAD = 2;
    private static final int NUMEROMESA = 1;
    private static final double PRECIO = 10000;

    private int capacidad;
    private int numeroMesa;
    private double precio;

    public MesaTestDataBuilder(){
        this.capacidad = CAPACIDAD;
        this.numeroMesa = NUMEROMESA;
        this.precio = PRECIO;
    }

    public Mesa build(){
        return new Mesa(id,this.capacidad,this.numeroMesa,this.precio);
    }

    public ComandoMesa buildComando(){
        return new ComandoMesa(capacidad,numeroMesa,precio);
    }

    public MesaEntity buildEntity(){
        MesaEntity mesaEntity = new MesaEntity();
        mesaEntity.setNumeroMesa(this.numeroMesa);
        mesaEntity.setId(id);
        mesaEntity.setCapacidad(this.capacidad);
        mesaEntity.setPrecio(this.precio);

        return mesaEntity;
    }
}

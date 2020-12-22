package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;

public class MesaBuilder {

    private MesaBuilder(){

    }

    public static Mesa convertirADominio(MesaEntity mesaEntity){
        Mesa mesa= null;

        if(mesaEntity !=null){
            mesa= new Mesa(mesaEntity.getId(),mesaEntity.getCapacidad(),mesaEntity.getNumeroMesa(),mesaEntity.getPrecio());
        }

        return mesa;
    }

    public static MesaEntity convertirAEntity(Mesa mesa){
        MesaEntity mesaEntity= new MesaEntity();
        mesaEntity.setId(mesa.getIdMesa());
        mesaEntity.setCapacidad(mesa.getCapacidadPersonas());
        mesaEntity.setNumeroMesa(mesa.getNumeroMesa());
        mesaEntity.setPrecio(mesa.getPrecio());

        return mesaEntity;
    }
}
package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;

import java.util.ArrayList;
import java.util.List;

public final class MesaBuilder {

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

    public static List<Mesa> convertirADominio(List<MesaEntity> mesas){
        ArrayList<Mesa> mesasDominio = new ArrayList<>();
        for (MesaEntity mesa : mesas){
            mesasDominio.add(convertirADominio(mesa));
        }

        return mesasDominio;
    }
}

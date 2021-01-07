package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.dto.DtoMesa;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;

import java.util.ArrayList;
import java.util.List;

public final class MesaBuilder {

    private MesaBuilder(){

    }

    public static DtoMesa convertirADto(MesaEntity mesaEntity){
        DtoMesa mesa= null;

        if(mesaEntity !=null){
            mesa= new DtoMesa(mesaEntity.getId(),mesaEntity.getCapacidad(),mesaEntity.getNumeroMesa(),mesaEntity.getPrecio());
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

    public static List<DtoMesa> convertirADominio(List<MesaEntity> mesas){
        ArrayList<DtoMesa> mesasDominio = new ArrayList<>();
        for (MesaEntity mesa : mesas){
            mesasDominio.add(convertirADto(mesa));
        }

        return mesasDominio;
    }
}

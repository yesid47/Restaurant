package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Rol;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.RolEntity;

public class RolBuilder {
    private RolBuilder(){

    }
    public static Rol convertirADominio(RolEntity rolEntity){
        Rol rol = null;

        if(rolEntity!=null){
            rol= new Rol(rolEntity.getId(),rolEntity.getNombreRol());
        }

        return rol;
    }

    public static RolEntity convertirAEntity(Rol rol){
        RolEntity rolEntity= new RolEntity();
        rolEntity.setId(rol.getIdRol());
        rolEntity.setNombreRol(rol.getNombre());

        return rolEntity;
    }
}

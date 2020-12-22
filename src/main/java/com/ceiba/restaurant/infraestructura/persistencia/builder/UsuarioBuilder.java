package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Usuario;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.UsuarioEntity;

public class UsuarioBuilder {

    UsuarioBuilder(){}

    public static Usuario convertirADominio(UsuarioEntity usuarioEntity){
        Usuario usuario= null;
        if(usuarioEntity!=null){
            usuario = new Usuario(usuarioEntity.getId(),usuarioEntity.getNombreUsuario(),usuarioEntity.getPassword(),null,null);
        }

        return usuario;
    }

    public static UsuarioEntity convertirAEntity(Usuario usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(usuario.getIdUser());
        usuarioEntity.setNombreUsuario(usuario.getNombreUsuario());
        usuarioEntity.setPassword(usuario.getPassword());
        usuarioEntity.setPersona(null);
        usuarioEntity.setRol(null);

        return usuarioEntity;
    }
}

package com.ceiba.restaurant.dominio.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.dto.DtoMesa;

import java.util.List;

public interface RepositorioMesa {

    void agregar(Mesa mesa);

    DtoMesa obtenerPorId(int id);

    List<DtoMesa> listarTodo();

    void eliminar(int numeroMesa);

    DtoMesa obtenerPorNumero(int numero);

    void actualizar(Mesa mesa);

}

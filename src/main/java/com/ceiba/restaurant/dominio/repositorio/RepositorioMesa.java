package com.ceiba.restaurant.dominio.repositorio;

import com.ceiba.restaurant.dominio.Mesa;

import java.util.List;

public interface RepositorioMesa {

    void agregar(Mesa mesa);

    Mesa obtenerPorId(int id);

    List<Mesa> listarTodo();

    void eliminar(int numeroMesa);

    Mesa obtenerPorNumero(int numero);
}

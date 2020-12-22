package com.ceiba.restaurant.dominio.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import org.springframework.stereotype.Component;

import java.util.List;

public interface RepositorioMesa {

    void agregar(Mesa mesa);

    Mesa obtenerPorId(int id);

    List<Mesa> listarMesas();

    void eliminar(long id);
}

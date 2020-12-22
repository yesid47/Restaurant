package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.aplicacion.manejador.manejadorMesa.ManejadorBuscarMesa;
import com.ceiba.restaurant.aplicacion.manejador.manejadorMesa.ManejadorCrearMesa;
import com.ceiba.restaurant.aplicacion.manejador.manejadorMesa.ManejadorListarMesas;
import com.ceiba.restaurant.dominio.Mesa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
public class ControladorMesa {
    private final ManejadorCrearMesa manejadorCrearMesa;
    private final ManejadorListarMesas manejadorListarMesas;
    private final ManejadorBuscarMesa manejadorBuscarMesa;

    public ControladorMesa(ManejadorCrearMesa manejadorCrearMesa,  ManejadorListarMesas  manejadorListarMesas, ManejadorBuscarMesa manejadorBuscarMesa){
        this.manejadorCrearMesa= manejadorCrearMesa;
        this.manejadorListarMesas = manejadorListarMesas;
        this.manejadorBuscarMesa = manejadorBuscarMesa;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoMesa comandoMesa){
        this.manejadorCrearMesa.ejecutar(comandoMesa);
    }

    @GetMapping("/{id}")
    public Mesa buscar(@PathVariable(name="id") int id){
        return this.manejadorBuscarMesa.ejecutar(id);
    }

    @GetMapping("/mesas")
    public List<Mesa> listarMesas(){
        return this.manejadorListarMesas.ejecutar();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable(name="id") int id){

    }
}

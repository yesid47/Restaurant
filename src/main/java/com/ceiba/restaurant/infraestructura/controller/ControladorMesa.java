package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.aplicacion.manejador.manejadormesa.ManejadorBuscarMesa;
import com.ceiba.restaurant.aplicacion.manejador.manejadormesa.ManejadorCrearMesa;
import com.ceiba.restaurant.aplicacion.manejador.manejadormesa.ManejadorEliminarMesa;
import com.ceiba.restaurant.aplicacion.manejador.manejadormesa.ManejadorListarMesas;
import com.ceiba.restaurant.dominio.Mesa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
public class ControladorMesa {
    private final ManejadorCrearMesa manejadorCrearMesa;
    private final ManejadorListarMesas manejadorListarMesas;
    private final ManejadorBuscarMesa manejadorBuscarMesa;
    private final ManejadorEliminarMesa manejadorEliminarMesa;

    public ControladorMesa(ManejadorCrearMesa manejadorCrearMesa, ManejadorListarMesas manejadorListarMesas, ManejadorBuscarMesa manejadorBuscarMesa, ManejadorEliminarMesa manejadorEliminarMesa){
        this.manejadorCrearMesa= manejadorCrearMesa;
        this.manejadorListarMesas = manejadorListarMesas;
        this.manejadorBuscarMesa = manejadorBuscarMesa;
        this.manejadorEliminarMesa = manejadorEliminarMesa;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoMesa comandoMesa){
        this.manejadorCrearMesa.ejecutar(comandoMesa);
    }


    @GetMapping("/{numeroMesa}")
    public Mesa buscarPorNumero(@PathVariable(name="numeroMesa") int numeroMesa){
        return this.manejadorBuscarMesa.ejecutar(numeroMesa);
    }

    @GetMapping("/mesas")
    public List<Mesa> listarMesas(){
        return this.manejadorListarMesas.ejecutar();
    }

    @DeleteMapping("/{numeroMesa}")
    public void eliminar(@PathVariable(name="numeroMesa") int numero){
        this.manejadorEliminarMesa.ejecutar(numero);
    }
}

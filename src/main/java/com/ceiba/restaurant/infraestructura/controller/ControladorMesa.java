package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoMesa;
import com.ceiba.restaurant.aplicacion.manejador.manejadormesa.*;
import com.ceiba.restaurant.dominio.Mesa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/mesa")
public class ControladorMesa {
    private final ManejadorCrearMesa manejadorCrearMesa;
    private final ManejadorListarMesas manejadorListarMesas;
    private final ManejadorBuscarMesa manejadorBuscarMesa;
    private final ManejadorEliminarMesa manejadorEliminarMesa;
    private final ManejadorActualizarMesa manejadorActualizarMesa;

    public ControladorMesa(ManejadorCrearMesa manejadorCrearMesa, ManejadorListarMesas manejadorListarMesas, ManejadorBuscarMesa manejadorBuscarMesa, ManejadorEliminarMesa manejadorEliminarMesa, ManejadorActualizarMesa manejadorActualizarMesa){
        this.manejadorCrearMesa= manejadorCrearMesa;
        this.manejadorListarMesas = manejadorListarMesas;
        this.manejadorBuscarMesa = manejadorBuscarMesa;
        this.manejadorEliminarMesa = manejadorEliminarMesa;
        this.manejadorActualizarMesa = manejadorActualizarMesa;
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

    @PutMapping("/{id}")
    public void actualizar(@RequestBody ComandoMesa comandoMesa,@PathVariable int id){
        comandoMesa.setIdMesa(id);
        this.manejadorActualizarMesa.ejecutar(comandoMesa);
    }
}

package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.aplicacion.manejador.manejadorPersona.ManejadorBuscarPersona;
import com.ceiba.restaurant.aplicacion.manejador.manejadorPersona.ManejadorCrearPersona;
import com.ceiba.restaurant.aplicacion.manejador.manejadorPersona.ManejadorListarPersonas;
import com.ceiba.restaurant.dominio.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControladorPersona {

    private final ManejadorCrearPersona manejadorCrearPersona;
    private final ManejadorListarPersonas manejadorListarPersonas;
    private final ManejadorBuscarPersona manejadorBuscarPersona;

    public ControladorPersona(ManejadorCrearPersona manejadorCrearPersona, ManejadorListarPersonas manejadorListarPersonas, ManejadorBuscarPersona manejadorBuscarPersona){
        this.manejadorCrearPersona= manejadorCrearPersona;
        this.manejadorListarPersonas = manejadorListarPersonas;
        this.manejadorBuscarPersona = manejadorBuscarPersona;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoPersona comandoPersona){
        this.manejadorCrearPersona.ejecutar(comandoPersona);

    }

    @GetMapping("/{id}")
        public Persona buscar(@PathVariable(name="id") long id){
            return this.manejadorBuscarPersona.ejecutar(id);
    }

    @GetMapping("/personas")
    public List<Persona> listarPersonas(){
        return this.manejadorListarPersonas.ejecutar();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable(name="id") int id){

    }
}
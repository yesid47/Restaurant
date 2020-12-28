package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.aplicacion.manejador.manejadorpersona.ManejadorBuscarPersona;
import com.ceiba.restaurant.aplicacion.manejador.manejadorpersona.ManejadorCrearPersona;
import com.ceiba.restaurant.aplicacion.manejador.manejadorpersona.ManejadorListarPersonas;
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

    @GetMapping("id/{id}")
        public Persona buscarPorId(@PathVariable(name="id") long id){
            return this.manejadorBuscarPersona.ejecutar(id);
    }

    @GetMapping("/{cedula}")
    public Persona buscarPorCedula(@PathVariable (name="cedula") String cedula){
        return this.manejadorBuscarPersona.ejecutar(cedula);
    }

    @GetMapping("/personas")
    public List<Persona> listarTodo(){
        return this.manejadorListarPersonas.ejecutar();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable(name="id") int id){

    }
}

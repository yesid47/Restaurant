package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.aplicacion.manejador.persona.*;
import com.ceiba.restaurant.dominio.Persona;
import com.ceiba.restaurant.dominio.dto.DtoPersona;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping("/persona")
public class ControladorPersona {

    private final ManejadorCrearPersona manejadorCrearPersona;
    private final ManejadorListarPersonas manejadorListarPersonas;
    private final ManejadorBuscarPersona manejadorBuscarPersona;
    private final ManejadorEliminarPersona manejadorEliminarPersona;
    private final ManejadorActualizarPersona manejadorActualizarPersona;

    public ControladorPersona(ManejadorCrearPersona manejadorCrearPersona, ManejadorListarPersonas manejadorListarPersonas, ManejadorBuscarPersona manejadorBuscarPersona, ManejadorEliminarPersona manejadorEliminarPersona, ManejadorActualizarPersona manejadorActualizarPersona){
        this.manejadorCrearPersona= manejadorCrearPersona;
        this.manejadorListarPersonas = manejadorListarPersonas;
        this.manejadorBuscarPersona = manejadorBuscarPersona;
        this.manejadorEliminarPersona = manejadorEliminarPersona;
        this.manejadorActualizarPersona = manejadorActualizarPersona;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoPersona comandoPersona){
        this.manejadorCrearPersona.ejecutar(comandoPersona);

    }

    @GetMapping("id/{id}")
        public DtoPersona buscarPorId(@PathVariable(name="id") long id){
            return this.manejadorBuscarPersona.ejecutar(id);
    }

    @GetMapping("/{cedula}")
    public DtoPersona buscarPorCedula(@PathVariable (name="cedula") String cedula){
        return this.manejadorBuscarPersona.ejecutar(cedula);
    }

    @GetMapping("/personas")
    public List<DtoPersona> listarTodo(){
        return this.manejadorListarPersonas.ejecutar();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable(name="id") long id){
        this.manejadorEliminarPersona.ejecutar(id);
    }

    @PutMapping("/{id}")
    public void actualizar(@RequestBody ComandoPersona comandoPersona,@PathVariable(name="id") long id){
        comandoPersona.setIdPersona(id);
        this.manejadorActualizarPersona.ejecutar(comandoPersona);
    }
}

package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.aplicacion.manejador.manejadorreserva.ManejadorCrearReserva;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reserva")
public class ControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;


    public ControladorReserva(ManejadorCrearReserva manejadorCrearReserva){
        this.manejadorCrearReserva= manejadorCrearReserva;

    }

    @PostMapping
    public void agregar(@RequestBody ComandoReserva comandoReserva){
       this.manejadorCrearReserva.ejecutar(comandoReserva);
    }

  /*  @GetMapping("/{id}")
    public Mesa buscar(@PathVariable(name="id") int id){
        return this.manejadorBuscarMesa.ejecutar(id);
    }

    @GetMapping("/mesas")
    public List<Mesa> listarMesas(){
        return this.manejadorListarMesas.ejecutar();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable(name="id") int id){

    }*/
}

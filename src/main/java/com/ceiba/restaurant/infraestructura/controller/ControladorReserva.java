package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.aplicacion.manejador.manejadorreserva.ManejadorCrearReserva;
import com.ceiba.restaurant.aplicacion.manejador.manejadorreserva.ManejadorValidarReserva;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reserva")
public class ControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorValidarReserva manejadorValidarReserva;


    public ControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorValidarReserva manejadorValidarReserva){
        this.manejadorCrearReserva= manejadorCrearReserva;
        this.manejadorValidarReserva = manejadorValidarReserva;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoReserva comandoReserva){
       this.manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @PostMapping("/validar")
    public boolean comprobarDisponibilidad(@RequestBody ComandoReserva comandoReserva){
        return this.manejadorValidarReserva.ejecutar(comandoReserva);
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

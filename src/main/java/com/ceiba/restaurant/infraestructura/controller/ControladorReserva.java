package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.aplicacion.manejador.manejadorreserva.*;
import com.ceiba.restaurant.dominio.Reserva;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("reserva")
public class ControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorValidarReserva manejadorValidarReserva;
    private final ManejadorUpdateEstado manejadorUpdateEstado;
    private final ManejadorListarReservas manejadorListarReservas;
    private final ManejadorEliminarReserva manejadorEliminarReserva;


    public ControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorValidarReserva manejadorValidarReserva, ManejadorUpdateEstado manejadorUpdateEstado, ManejadorListarReservas manejadorListarReservas, ManejadorEliminarReserva manejadorEliminarReserva){
        this.manejadorCrearReserva= manejadorCrearReserva;
        this.manejadorValidarReserva = manejadorValidarReserva;
        this.manejadorUpdateEstado = manejadorUpdateEstado;
        this.manejadorListarReservas = manejadorListarReservas;
        this.manejadorEliminarReserva = manejadorEliminarReserva;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoReserva comandoReserva){
        this.manejadorUpdateEstado.ejecutar();
       this.manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @PostMapping("/validar")
    public boolean comprobarDisponibilidad(@RequestBody ComandoReserva comandoReserva){
        return this.manejadorValidarReserva.ejecutar(comandoReserva);
    }

    @GetMapping("/actualizarEstados")
    public void actualizarEstado (){
        this.manejadorUpdateEstado.ejecutar();
    }

    @GetMapping("/reservas")
    public List<Reserva> listarTodo(){
        return this.manejadorListarReservas.ejecutar();
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable(name="id") int id){
        this.manejadorEliminarReserva.ejecutar(id);
    }
}

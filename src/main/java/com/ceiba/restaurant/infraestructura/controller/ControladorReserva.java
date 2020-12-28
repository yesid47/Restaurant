package com.ceiba.restaurant.infraestructura.controller;

import com.ceiba.restaurant.aplicacion.comando.ComandoReserva;
import com.ceiba.restaurant.aplicacion.manejador.manejadorreserva.ManejadorCrearReserva;
import com.ceiba.restaurant.aplicacion.manejador.manejadorreserva.ManejadorListarReservas;
import com.ceiba.restaurant.aplicacion.manejador.manejadorreserva.ManejadorUpdateEstado;
import com.ceiba.restaurant.aplicacion.manejador.manejadorreserva.ManejadorValidarReserva;
import com.ceiba.restaurant.dominio.Reserva;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reserva")
public class ControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorValidarReserva manejadorValidarReserva;
    private final ManejadorUpdateEstado manejadorUpdateEstado;
    private final ManejadorListarReservas manejadorListarReservas;


    public ControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorValidarReserva manejadorValidarReserva, ManejadorUpdateEstado manejadorUpdateEstado, ManejadorListarReservas manejadorListarReservas){
        this.manejadorCrearReserva= manejadorCrearReserva;
        this.manejadorValidarReserva = manejadorValidarReserva;
        this.manejadorUpdateEstado = manejadorUpdateEstado;
        this.manejadorListarReservas = manejadorListarReservas;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoReserva comandoReserva){
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

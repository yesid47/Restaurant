package com.ceiba.restaurant.aplicacion.manejador.reserva;

import com.ceiba.restaurant.dominio.servicio.reserva.ServicioUpdateEstado;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ManejadorUpdateEstado {

    ServicioUpdateEstado servicioUpdateEstado;

    public ManejadorUpdateEstado(ServicioUpdateEstado servicioUpdateEstado){
        this.servicioUpdateEstado = servicioUpdateEstado;
    }

    @Transactional
    public void ejecutar (){
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        this.servicioUpdateEstado.ejecutar(fechaActual,horaActual);
    }
}

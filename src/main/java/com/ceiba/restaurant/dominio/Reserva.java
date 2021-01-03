package com.ceiba.restaurant.dominio;


import java.time.LocalDate;
import java.time.LocalTime;

import static com.ceiba.restaurant.dominio.ValidadorArgumento.*;


public class Reserva {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_LA_RESERVA ="Se debe ingresar la fecha de la reserva";
    private static final String SE_DEBE_INGRESAR_LA_HORA_DE_INICIO_DE_LA_RESERVA ="Se debe ingresar la hora de inicio de la reserva";
    private static final String SE_DEBE_INGRESAR_LA_PERSONA_QUE_HACE_LA_RESERVA = "Se debe ingresar la persona que hace la reserva";
    private static final String SE_DEBE_INGRESAR_LA_MESA_A_RESERVAR = "Se debe ingresar la mesa a reservar";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA_VALIDA = "Se debe ingresar una fecha valida entre jueves y domingo";
    private static final String SE_DEBE_INGRESAR_UNA_HORA_DE_INICIO_VALIDA = "Se debe ingresar una hora de inicio entre las 08:00 y las 20:00 horas";

    private static final double TARIFA_JUEVES = 0.5;
    private static final double TARIFA_DOMINGO= 2.0;
    private static final int DURACION_MINUTOS_RESERVA = 120 ;
    private static final String JUEVES = "THURSDAY";
    private static final String DOMINGO = "SUNDAY";


    private long idReserva;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private Persona persona;
    private Mesa mesa;
    private double valorAPagar;
    private boolean estado;


    public Reserva(LocalDate fecha, LocalTime horaInicio, LocalTime horaFinal, Persona persona,
                   Mesa mesa, double valorAPagar, boolean estado) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.persona = persona;
        this.mesa = mesa;
        this.valorAPagar = valorAPagar;
        this.estado = estado;
    }

    public Reserva(long idReserva, LocalDate fecha, LocalTime horaInicio, Persona persona, Mesa mesa) {

            validarObligatorio(fecha,SE_DEBE_INGRESAR_LA_FECHA_DE_LA_RESERVA);
            validarFecha(fecha,SE_DEBE_INGRESAR_UNA_FECHA_VALIDA);
            validarObligatorio(horaInicio,SE_DEBE_INGRESAR_LA_HORA_DE_INICIO_DE_LA_RESERVA);
            validarHora(horaInicio,SE_DEBE_INGRESAR_UNA_HORA_DE_INICIO_VALIDA);
            validarObligatorio(persona,SE_DEBE_INGRESAR_LA_PERSONA_QUE_HACE_LA_RESERVA);
            validarObligatorio(mesa, SE_DEBE_INGRESAR_LA_MESA_A_RESERVAR);

            this.idReserva = idReserva;
            this.fecha = fecha;
            this.horaInicio = horaInicio;
            this.persona = persona;
            this.mesa = mesa;
            this.horaFinal = calcularHoraFinal(horaInicio);
            this.valorAPagar = calcularValorApagar(mesa.getPrecio(), fecha);
            this.estado = true;
    }



    public double calcularValorApagar(double precioMesa, LocalDate fecha) {
        double valorPagar = 0;
        if(calcularSiEsJueves(fecha)){
            valorPagar = precioMesa*TARIFA_JUEVES;
        }
        else if(calcularSiEsDomingo(fecha)){
            valorPagar = precioMesa*TARIFA_DOMINGO;
        }
        else{
            valorPagar = precioMesa;
        }

        return valorPagar;
    }


    public boolean calcularSiEsJueves(LocalDate fecha){
        return (fecha.getDayOfWeek().toString().equals(JUEVES));
    }

    public boolean calcularSiEsDomingo(LocalDate fecha){
        return (fecha.getDayOfWeek().toString().equals(DOMINGO));
    }


    public LocalTime calcularHoraFinal(LocalTime horaInicio){

        return horaInicio.plusMinutes(DURACION_MINUTOS_RESERVA);
    }


    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }


    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public boolean getEstado() {
        return estado;
    }

}

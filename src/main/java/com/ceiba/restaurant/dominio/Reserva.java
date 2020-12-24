package com.ceiba.restaurant.dominio;


import java.time.LocalDate;
import java.time.LocalTime;


public class Reserva {

    private static final double TARIFA_JUEVES = 0.5;
    private static final double TARIFA_DOMINGO= 2.0;
    private static final int DURACION_MINUTOS_RESERVA = 120 ;
    private static final String LUNES = "MONDAY";
    private static final String MARTES = "TUESDAY";
    private static final String MIERCOLES = "WEDNESDAY";
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

    public Reserva (){

    }

    public Reserva(long idReserva, LocalDate fecha, LocalTime horaInicio, LocalTime horaFinal, Persona persona, Mesa mesa, double valorAPagar, boolean estado) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.persona = persona;
        this.mesa = mesa;
        this.valorAPagar = valorAPagar;
        this.estado = estado;
    }

    public Reserva(long idReserva, LocalDate fecha, LocalTime horaInicio, Persona persona, Mesa mesa) {
        if (fechaEsValida(fecha)){
            this.idReserva = idReserva;
            this.fecha = fecha;
            this.horaInicio = horaInicio;
            this.persona = persona;
            this.mesa = mesa;
            this.horaFinal = calcularHoraFinal(horaInicio);
            this.valorAPagar = calcularValorApagar(mesa.getPrecio(), fecha);
            this.estado = true;
        }
    }



    public double calcularValorApagar(double precioMesa, LocalDate fecha) {
        double valorAPagar = 0;
        if(calcularSiEsJueves(fecha)){
            valorAPagar = precioMesa*TARIFA_JUEVES;
        }
        else if(calcularSiEsDomingo(fecha)){
            valorAPagar = precioMesa*TARIFA_DOMINGO;
        }
        else{
            valorAPagar = precioMesa;
        }

        return valorAPagar;
    }

    public boolean fechaEsValida(LocalDate fecha){
        boolean esValida = true;
        if(fecha.getDayOfWeek().toString().equals(LUNES) || fecha.getDayOfWeek().toString().equals(MARTES) || fecha.getDayOfWeek().toString().equals(MIERCOLES)){
            esValida = false;
        }

        return esValida;
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

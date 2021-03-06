package com.ceiba.restaurant.dominio;

import com.ceiba.restaurant.dominio.excepcion.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidadorArgumento {

    private static final String LUNES = "MONDAY";
    private static final String MARTES = "TUESDAY";
    private static final String MIERCOLES = "WEDNESDAY";
    private static final LocalTime horaInicial = LocalTime.parse("08:00");
    private static final LocalTime horaFinal = LocalTime.parse("20:00");
	
	private ValidadorArgumento() {}

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }

    public static void validarFecha(LocalDate fecha, String mensaje){
        if(fecha.getDayOfWeek().toString().equals(LUNES) || fecha.getDayOfWeek().toString().equals(MARTES) || fecha.getDayOfWeek().toString().equals(MIERCOLES) || fecha.isBefore(LocalDate.now()) ){
            throw new ExcepcionFechaInvalida(mensaje);
        }
    }

    public static void validarFechaHora(LocalDate fecha,LocalTime horaInicio,String mensaje){
	    if(fecha.equals(LocalDate.now()) && horaInicio.isBefore(LocalTime.now())){
            throw new ExcepcionFechaInvalida(mensaje);
        }
    }

    public static void validarHora(LocalTime horaInicio, String mensaje){
	    if(horaInicio.isBefore(horaInicial) || horaInicio.isAfter(horaFinal)){
	        throw new ExcepcionHoraInvalida(mensaje);
        }
    }
    
    public static void validarLongitud(String valor,int longitud,String mensaje){
        if(valor.length() < longitud){
            throw new ExcepcionLongitudValor(mensaje);
        }
    }


    public static void validarPositivo(Double valor, String mensaje) {
        if (valor <= 0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarLongitudMinima(Object valor, int longitudMinima, String mensaje) {
        if (valor.toString().length() < longitudMinima) {
            throw new ExcepcionLongitudValor(mensaje);
        }
    }


    public static void validarRegex(String correoElectronico, String regex, String mensaje) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correoElectronico);

        if (!matcher.matches()) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }


    public static void validarNumerico(String valor,String mensaje) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException numberFormatException) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
}

package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionFechaInvalida;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionHoraInvalida;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.restaurant.dominio.excepcion.ExcepcionValorObligatorio;
import org.apache.tomcat.jni.Local;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.ceiba.restaurant.dominio.ValidadorArgumento.*;
import static org.junit.Assert.fail;

public class ValidadorArgumentoTest {

    private static final String CAMPO_REQUERIDO = "El campo es requerido";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA_VALIDA = "Se debe ingresar una fecha valida entre jueves y domingo";
    private static final String SE_DEBE_INGRESAR_UNA_HORA_DE_INICIO_VALIDA = "Se debe ingresar una hora de inicio entre las 08:00 y las 20:00 horas";
    private static final String SE_DEBE_INGRESAR_UN_EMAIL_VALIDO = "Se debe ingresar un email valido";


    private static final LocalDate fechaLunes = LocalDate.parse("2020-12-28");
    private static final LocalDate fechaMartes = LocalDate.parse("2020-12-29");
    private static final LocalDate fechaMiercoles = LocalDate.parse("2020-12-30");
    private static final LocalTime horaInicio = LocalTime.parse("07:59");
    private static final LocalTime horaLimite = LocalTime.parse("20:01");
    private static final String emailInvalido= "hola@gmail";
    private static String REGEX_EMAIL = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

    @Test
    public void validarObligatorioTest(){

        //arrange
        ComandoPersona persona= null;

        //act
        try {
            validarObligatorio(persona,CAMPO_REQUERIDO);
            fail();
        }catch (ExcepcionValorObligatorio e) {
            //assert
            Assert.assertEquals(CAMPO_REQUERIDO, e.getMessage());
        }
    }

    @Test
    public void validarFechaLunesTest(){
        //act
        try {
            validarFecha(fechaLunes,SE_DEBE_INGRESAR_UNA_FECHA_VALIDA);
            fail();
        }catch (ExcepcionFechaInvalida e) {
            //assert
            Assert.assertEquals(SE_DEBE_INGRESAR_UNA_FECHA_VALIDA, e.getMessage());
        }
    }

    @Test
    public void validarFechaMartesTest(){
        //act
        try {
            validarFecha(fechaMartes,SE_DEBE_INGRESAR_UNA_FECHA_VALIDA);
            fail();
        }catch (ExcepcionFechaInvalida e) {
            //assert
            Assert.assertEquals(SE_DEBE_INGRESAR_UNA_FECHA_VALIDA, e.getMessage());
        }
    }

    @Test
    public void validarFechaMiercolesTest(){
        //act
        try {
            validarFecha(fechaMiercoles,SE_DEBE_INGRESAR_UNA_FECHA_VALIDA);
            fail();
        }catch (ExcepcionFechaInvalida e) {
            //assert
            Assert.assertEquals(SE_DEBE_INGRESAR_UNA_FECHA_VALIDA, e.getMessage());
        }
    }

    @Test
    public void validarHoraAntesDeLas8Test(){
        //act
        try {
            validarHora(horaInicio,SE_DEBE_INGRESAR_UNA_HORA_DE_INICIO_VALIDA);
            fail();
        }catch (ExcepcionHoraInvalida e) {
            //assert
            Assert.assertEquals(SE_DEBE_INGRESAR_UNA_HORA_DE_INICIO_VALIDA, e.getMessage());
        }
    }

    @Test
    public void validarHoraDespuesDeLas20Test(){
        //act
        try {
            validarHora(horaLimite,SE_DEBE_INGRESAR_UNA_HORA_DE_INICIO_VALIDA);
            fail();
        }catch (ExcepcionHoraInvalida e) {
            //assert
            Assert.assertEquals(SE_DEBE_INGRESAR_UNA_HORA_DE_INICIO_VALIDA, e.getMessage());
        }
    }

    @Test
    public void validarRegexEmailTest(){

        //act
        try {
            validarRegex(emailInvalido,REGEX_EMAIL,SE_DEBE_INGRESAR_UN_EMAIL_VALIDO);
            fail();
        }catch (ExcepcionValorInvalido e) {
            //assert
            Assert.assertEquals(SE_DEBE_INGRESAR_UN_EMAIL_VALIDO, e.getMessage());
        }
    }
}

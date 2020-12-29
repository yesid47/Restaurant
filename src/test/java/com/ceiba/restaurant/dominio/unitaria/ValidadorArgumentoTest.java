package com.ceiba.restaurant.dominio.unitaria;

import com.ceiba.restaurant.aplicacion.comando.ComandoPersona;
import com.ceiba.restaurant.dominio.excepcion.*;
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
    private static final String EL_VALOR_DE_LA_MESA_DEBE_SER_POSITIVO = "Se debe ingresar el precio de la mesa";
    private static final String EL_NOMBRE_INGRESADO_ES_MUY_CORTO = "Se debe ingresar el nombre completo";
    private static final String EL_VALOR_INGRESADO_ES_MUY_LARGO = "El valor es muy largo maximo 5";
    private static final String DEBE_SER_UN_VALOR_NUMERICO = "la cedula debe ser un valor numerico";


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

    @Test
    public void validarPositivoTest(){
        //arrange
        double valorNegativo = -5000;

        //act
        try {
            validarPositivo(valorNegativo,EL_VALOR_DE_LA_MESA_DEBE_SER_POSITIVO);
            fail();
        }catch (ExcepcionValorInvalido e) {
            //assert
            Assert.assertEquals(EL_VALOR_DE_LA_MESA_DEBE_SER_POSITIVO, e.getMessage());
        }
    }

    @Test void validarLongitudMinimaTest(){
        //arrange
        String nombre = "Yesid";
        int longitudMinima = 10;

        //act
        try {
            validarLongitudMinima(nombre,longitudMinima,EL_NOMBRE_INGRESADO_ES_MUY_CORTO);
            fail();
        }catch (ExcepcionLongitudValor e) {
            //assert
            Assert.assertEquals(EL_NOMBRE_INGRESADO_ES_MUY_CORTO, e.getMessage());
        }
    }

    @Test
    void validarLongitudTest(){
        //arrange
        String nombre = "Pedro";
        int longitudMaxima = 10;

        //act
        try {
            validarLongitud(nombre,longitudMaxima,EL_VALOR_INGRESADO_ES_MUY_LARGO);
            fail();
        }catch (ExcepcionLongitudValor e) {
            //assert
            Assert.assertEquals(EL_VALOR_INGRESADO_ES_MUY_LARGO, e.getMessage());
        }
    }

    @Test
    void validarNumericoTest(){
        //arrange
        String nombre = "555H";

        //act
        try {
            validarNumerico(nombre,DEBE_SER_UN_VALOR_NUMERICO);
            fail();
        }catch (ExcepcionValorInvalido e) {
            //assert
            Assert.assertEquals(DEBE_SER_UN_VALOR_NUMERICO, e.getMessage());
        }
    }


}

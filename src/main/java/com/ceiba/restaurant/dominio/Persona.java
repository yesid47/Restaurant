package com.ceiba.restaurant.dominio;

import static com.ceiba.restaurant.dominio.ValidadorArgumento.*;

public class Persona {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PERSONA = "Se debe ingresar el nombre de la persona";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA_DE_LA_PERSONA = "Se debe ingresar la cédula de la persona";
    private static final String SE_DEBE_INGRESAR_EL_CELULAR_DE_LA_PERSONA = "Se debe ingresar el celular de la persona";
    private static final String SE_DEBE_INGRESAR_UN_CELULAR_VALIDO = "Se debe ingresar un número de celular valido";
    private static final String SE_DEBE_INGRESAR_UN_CELULAR_CON_5_CARACTERES = "Se debe ingresar un número de celular con al menos 5 números";
    private static final String SE_DEBE_INGRESAR_EL_EMAIL_DE_LA_PERSONA = "Se debe ingresar el correo electrónico de la persona";
    private static final String SE_DEBE_INGRESAR_UN_EMAIL_VALIDO = "Se debe ingresar un email valido";

    private static final String REGEX_EMAIL = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

    private long idPersona;
    private String nombre;
    private String cedula;
    private long celular;
    private String email;
    private String direccion;


    public Persona(String nombre, String cedula, long celular, String email, String direccion) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PERSONA);
        validarObligatorio(cedula,SE_DEBE_INGRESAR_LA_CEDULA_DE_LA_PERSONA);
        validarObligatorio(celular,SE_DEBE_INGRESAR_EL_CELULAR_DE_LA_PERSONA);
        validarPositivo((double) celular,SE_DEBE_INGRESAR_UN_CELULAR_VALIDO);
        validarLongitudMinima(celular,5,SE_DEBE_INGRESAR_UN_CELULAR_CON_5_CARACTERES);
        validarObligatorio(celular,SE_DEBE_INGRESAR_EL_CELULAR_DE_LA_PERSONA);
        validarObligatorio(email,SE_DEBE_INGRESAR_EL_EMAIL_DE_LA_PERSONA);
        validarRegex(email,REGEX_EMAIL,SE_DEBE_INGRESAR_UN_EMAIL_VALIDO);

        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombre;
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public long getCelular() {
        return celular;
    }


    public String getEmail() {
        return email;
    }


    public String getDireccion() {
        return direccion;
    }

}

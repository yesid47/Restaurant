package com.ceiba.restaurant.dominio;

import static com.ceiba.restaurant.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.restaurant.dominio.ValidadorArgumento.validarRegex;

public class Persona {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PERSONA = "Se debe ingresar el nombre de la persona";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA_DE_LA_PERSONA = "Se debe ingresar la cédula de la persona";
    private static final String SE_DEBE_INGRESAR_EL_CELULAR_DE_LA_PERSONA = "Se debe ingresar el celular de la persona";
    private static final String SE_DEBE_INGRESAR_EL_EMAIL_DE_LA_PERSONA = "Se debe ingresar el correo electrónico de la persona";
    private static final String SE_DEBE_INGRESAR_UN_EMAIL_VALIDO = "Se debe ingresar un email valido";
    private static String REGEX_EMAIL = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

    private long idPersona;
    private String nombre;
    private String cedula;
    private long celular;
    private String email;
    private String direccion;

    public Persona(){
        super();
    }

    public Persona(long idPersona, String nombre, String cedula, long celular, String email, String direccion) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PERSONA);
        validarObligatorio(cedula,SE_DEBE_INGRESAR_LA_CEDULA_DE_LA_PERSONA);
        validarObligatorio(celular,SE_DEBE_INGRESAR_EL_CELULAR_DE_LA_PERSONA);
        validarObligatorio(email,SE_DEBE_INGRESAR_EL_EMAIL_DE_LA_PERSONA);
        validarRegex(email,REGEX_EMAIL,SE_DEBE_INGRESAR_UN_EMAIL_VALIDO);

        this.idPersona = idPersona;
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

    public void setNombrePersona(String nombre) {
        this.nombre = nombre;
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

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

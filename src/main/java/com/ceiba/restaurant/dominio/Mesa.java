package com.ceiba.restaurant.dominio;

import static com.ceiba.restaurant.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.restaurant.dominio.ValidadorArgumento.validarPositivo;

public class Mesa {

    private static final String SE_DEBE_INGRESAR_LA_CAPACIDAD_DE_LA_MESA = "Se debe ingresar la capacidad de la mesa";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_MESA = "Se debe ingresar el numero de mesa";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_MESA = "Se debe ingresar el precio de la mesa";
    private static final String LOS_VALORES_DEBEN_SER_POSITIVOS = "Los valores deben ser positivos";

    private int idMesa;
    private int capacidadPersonas;
    private int numeroMesa;
    private double precio;


    public Mesa(int capacidadPersonas, int numeroMesa, double precio) {

        validarObligatorio(capacidadPersonas,SE_DEBE_INGRESAR_LA_CAPACIDAD_DE_LA_MESA);
        validarObligatorio(numeroMesa,SE_DEBE_INGRESAR_EL_NUMERO_DE_MESA);
        validarObligatorio(precio,SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_MESA);
        validarPositivo((double) numeroMesa,LOS_VALORES_DEBEN_SER_POSITIVOS);
        validarPositivo((double) capacidadPersonas,LOS_VALORES_DEBEN_SER_POSITIVOS);
        validarPositivo(precio,LOS_VALORES_DEBEN_SER_POSITIVOS);

        this.capacidadPersonas = capacidadPersonas;
        this.numeroMesa = numeroMesa;
        this.precio = precio;

    }

    public double getPrecio() {
        return precio;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
}

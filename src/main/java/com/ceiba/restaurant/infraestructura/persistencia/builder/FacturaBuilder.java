package com.ceiba.restaurant.infraestructura.persistencia.builder;

import com.ceiba.restaurant.dominio.Factura;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.FacturaEntity;

public class FacturaBuilder {

    FacturaBuilder(){}

    public static Factura convertirADominio(FacturaEntity facturaEntity){
        Factura factura= null;
        if(facturaEntity!=null){
            factura = new Factura(facturaEntity.getId(),facturaEntity.getConsecutivoFactura(),facturaEntity.getValorAPagar(),null);
        }

        return factura;
    }

    public static FacturaEntity convertirAEntity(Factura factura){
        FacturaEntity facturaEntity= new FacturaEntity();

        facturaEntity.setId(factura.getIdFactura());
        facturaEntity.setConsecutivoFactura(factura.getConsecutivo());
        facturaEntity.setValorAPagar(factura.getValorAPagar());
        //facturaEntity.setReserva(null);

        return facturaEntity;
    }
}

package com.ceiba.restaurant.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="factura")
public class FacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="consecutivoFactura")
    private long consecutivoFactura;
    @Column(name="valorAPagar")
    private double valorAPagar;

    @OneToMany
    @JoinColumn(name="id_reserva",referencedColumnName="id")
    private List<ReservaEntity> reserva;

    public long getId() {
        return id;
    }


    public long getConsecutivoFactura() {
        return consecutivoFactura;
    }

    public void setConsecutivoFactura(long consecutivoFactura) {
        this.consecutivoFactura = consecutivoFactura;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ReservaEntity> getReserva() {
        return reserva;
    }

    public void setReserva(List<ReservaEntity> reserva) {
        this.reserva = reserva;
    }
}

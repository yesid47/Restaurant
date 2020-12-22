package com.ceiba.restaurant.dominio;

public class Factura {

    private long idFactura;
    private long consecutivo;
    private double valorAPagar;
    private Reserva reserva;

    public Factura(){
        super();
    }

    public Factura(long idFactura, long consecutivo, double valorAPagar, Reserva reserva) {
        this.idFactura = idFactura;
        this.consecutivo = consecutivo;
        this.valorAPagar = valorAPagar;
        this.reserva = reserva;
    }

    public long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(long idFactura) {
        this.idFactura = idFactura;
    }

    public long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}

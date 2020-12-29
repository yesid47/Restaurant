package com.ceiba.restaurant.infraestructura.persistencia.entidad;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity(name="reserva")
@Table(name="reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    private PersonaEntity persona;

    @OneToOne
    @JoinColumn(name = "id_mesa", referencedColumnName = "id")
    private MesaEntity mesa;
    @Column(name = "fecha", nullable = false )
    private LocalDate fecha;
    @Column(name = "hora_inicial", nullable = false)
    private LocalTime horaInicial;
    @Column(name = "hora_final", nullable = false)
    private LocalTime horaFinal;
    @Column(name = "valor_pagar", nullable = false)
    private double valorPagar;
    @Column(name = "estado", nullable = false)
    private boolean estado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PersonaEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    public MesaEntity getMesa() {
        return mesa;
    }

    public void setMesa(MesaEntity mesa) {
        this.mesa = mesa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

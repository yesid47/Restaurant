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
    private LocalTime hora_inicial;
    @Column(name = "hora_final", nullable = false)
    private LocalTime hora_final;
    @Column(name = "valor_pagar", nullable = false)
    private double valor_pagar;
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
        return hora_inicial;
    }

    public void setHoraInicial(LocalTime hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    public LocalTime getHoraFinal() {
        return hora_final;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.hora_final = horaFinal;
    }

    public double getValor_pagar() {
        return valor_pagar;
    }

    public void setValor_pagar(double valor_pagar) {
        this.valor_pagar = valor_pagar;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

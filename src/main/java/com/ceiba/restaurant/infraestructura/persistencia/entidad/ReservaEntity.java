package com.ceiba.restaurant.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
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

    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "horaInicial")
    private LocalTime horaInicial;
    @Column(name = "horaFinal")
    private LocalTime horaFinal;

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
}

package com.ceiba.restaurant.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName="id")
    private UsuarioEntity usuario;

    @OneToOne
    @JoinColumn(name="id_mesa",referencedColumnName="id")
    private MesaEntity mesa;

    @Column(name="fecha")
    private Date fecha;
    @Column(name="horaInicial")
    private Date horaInicial;
    @Column(name="horaFinal")
    private Date horaFinal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public MesaEntity getMesa() {
        return mesa;
    }

    public void setMesa(MesaEntity mesa) {
        this.mesa = mesa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }
}

package com.ceiba.restaurant.infraestructura.persistencia.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import com.ceiba.restaurant.infraestructura.persistencia.builder.MesaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.builder.ReservaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.repositorio.jpa.RepositorioReservaJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioReservaPersistente implements RepositorioReserva, RepositorioReservaJPA {

    private static final String FIND_ALL="SELECT reserva FROM reserva as reserva";
    private static final String DISPONIBILIDAD_MESA=
            "SELECT reserva FROM reserva as reserva WHERE reserva.fecha = :fecha and reserva.mesa = :id_mesa and (reserva.horaFinal BETWEEN :horaInicial and :horaFinal or reserva.horaInicial BETWEEN :horaInicial and :horaFinal)";
    private static final String ACTUALIZAR_ESTADO = "UPDATE reserva SET estado = 'false' WHERE (fecha = :fechaActual AND hora_Final <= :horaActual) OR (fecha <= :fechaActual)";

    private EntityManager entityManager;

    public RepositorioReservaPersistente(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public Reserva obtenerPorId(long id) {
        ReservaEntity reservaEntity = obtenerEntityPorId(id);
        return ReservaBuilder.convertirADominio(reservaEntity);
    }

    @Override
    public ReservaEntity obtenerEntityPorId(long id){
        return entityManager.find(ReservaEntity.class,id);
    }

    @Override
    public void agregar(Reserva reserva) {
        entityManager.persist(ReservaBuilder.convertirAEntity(reserva));
    }


    @Override
    public List<Reserva> listarTodo() {
        Query query = entityManager.createQuery(FIND_ALL);
        ArrayList<ReservaEntity> listaEntity = (ArrayList<ReservaEntity>) query.getResultList();
        return ReservaBuilder.convertirADominio(listaEntity);
    }

    @Override
    public boolean validarDisponibilidad(LocalDate fecha, LocalTime horaInicial, LocalTime horaFinal, Mesa mesa) {
        MesaEntity mesaEntity = MesaBuilder.convertirAEntity(mesa);
        Query query = entityManager.createQuery(DISPONIBILIDAD_MESA);
        query.setParameter("fecha",fecha);
        query.setParameter("id_mesa",mesaEntity);
        query.setParameter("horaInicial",horaInicial);
        query.setParameter("horaFinal",horaFinal);
        return  (ReservaBuilder.convertirABool(query.getResultList()));
    }

    @Override
    public void actualizarEstado(LocalDate fechaActual, LocalTime horaActual) {
        Query query = entityManager.createNativeQuery(ACTUALIZAR_ESTADO);
        query.setParameter("fechaActual", fechaActual);
        query.setParameter("horaActual", horaActual);

        query.executeUpdate();
    }

    @Override
    public void eliminar(long id) {
        ReservaEntity reservaEntity = obtenerEntityPorId(id);
        entityManager.remove(reservaEntity);
    }


}

package com.ceiba.restaurant.infraestructura.persistencia.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import com.ceiba.restaurant.infraestructura.persistencia.builder.MesaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.builder.ReservaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioReservaPersistente implements RepositorioReserva {

    private static final String FIND_ALL="SELECT reserva FROM reserva as reserva";
    private static final String disponibilidadMesa=
            "SELECT reserva FROM reserva as reserva WHERE reserva.fecha = :fecha and reserva.mesa = :id_mesa and (reserva.hora_final BETWEEN :horaInicial and :horaFinal or reserva.hora_inicial BETWEEN :horaInicial and :horaFinal)";
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

    public ReservaEntity obtenerEntityPorId(long id){
        ReservaEntity query = entityManager.find(ReservaEntity.class,id);
        return query;
    }

    @Override
    public void agregar(Reserva reserva) {
        entityManager.persist(ReservaBuilder.convertirAEntity(reserva));
    }


    @Override
    public List<Reserva> listarTodo() {
        Query query = entityManager.createQuery(FIND_ALL);
        ArrayList<Reserva> listaDominio = new ArrayList<>();
        ArrayList<ReservaEntity> listaEntity = (ArrayList<ReservaEntity>) query.getResultList();
        for (ReservaEntity reserva : listaEntity){
            listaDominio.add(ReservaBuilder.convertirADominio(reserva));
        }

        return listaDominio;
    }

    @Override
    public boolean validarDisponibilidad(LocalDate fecha, LocalTime horaInicial, LocalTime horaFinal, Mesa mesa) {
        MesaEntity mesaEntity = MesaBuilder.convertirAEntity(mesa);
        Query query = entityManager.createQuery(disponibilidadMesa);
        query.setParameter("fecha",fecha);
        query.setParameter("id_mesa",mesaEntity);
        query.setParameter("horaInicial",horaInicial);
        query.setParameter("horaFinal",horaFinal);
        return  (query.getResultList().size()>0);
    }

    @Override
    public void actualizarEstado(LocalDate fechaActual, LocalTime horaActual) {
        Query query = entityManager.createNativeQuery(ACTUALIZAR_ESTADO);
        query.setParameter("fechaActual", fechaActual);
        query.setParameter("horaActual", horaActual);

        query.executeUpdate();
    }

}

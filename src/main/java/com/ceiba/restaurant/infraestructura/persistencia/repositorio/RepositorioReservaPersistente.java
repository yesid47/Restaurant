package com.ceiba.restaurant.infraestructura.persistencia.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.Reserva;
import com.ceiba.restaurant.dominio.repositorio.RepositorioReserva;
import com.ceiba.restaurant.infraestructura.persistencia.builder.ReservaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.ReservaEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioReservaPersistente implements RepositorioReserva {

    private static final String FIND_ALL="SELECT reserva FROM reserva as reserva";

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
    public Mesa obtenerMesaReservada(int id) {
        return null;
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
}

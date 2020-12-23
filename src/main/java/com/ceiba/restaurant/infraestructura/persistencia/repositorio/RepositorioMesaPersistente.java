package com.ceiba.restaurant.infraestructura.persistencia.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.infraestructura.persistencia.builder.MesaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioMesaPersistente implements RepositorioMesa {
    private static final String FIND_ALL ="SELECT mesa FROM mesa as mesa";

    private EntityManager entityManager;

    public RepositorioMesaPersistente(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void agregar(Mesa mesa) {
        entityManager.persist(MesaBuilder.convertirAEntity(mesa));
    }

    @Override
    public Mesa obtenerPorId(int id) {
        MesaEntity mesaEntity = obtenerMesaEntityPorId(id);
        return MesaBuilder.convertirADominio(mesaEntity);
    }

    private MesaEntity obtenerMesaEntityPorId(int id) {
        MesaEntity query = entityManager.find(MesaEntity.class,id);
        return query;
    }

    @Override
    public List<Mesa> listarMesas() {
        Query query = entityManager.createQuery(FIND_ALL);
        ArrayList<Mesa> mesasDominio = new ArrayList<Mesa>();
        ArrayList<MesaEntity> mesas = (ArrayList<MesaEntity>) query.getResultList();
        for (MesaEntity mesa : mesas){
            mesasDominio.add(MesaBuilder.convertirADominio(mesa));
        }

        return mesasDominio;
    }

    @Override
    public void eliminar(long id) {

    }
}

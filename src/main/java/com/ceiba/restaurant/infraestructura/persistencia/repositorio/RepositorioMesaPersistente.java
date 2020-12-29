package com.ceiba.restaurant.infraestructura.persistencia.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.infraestructura.error.ManejadorError;
import com.ceiba.restaurant.infraestructura.persistencia.builder.MesaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioMesaPersistente implements RepositorioMesa {
    private static final String FIND_ALL ="SELECT mesa FROM mesa as mesa";
    private static final String FIND_BY_NUMERO = "SELECT mesa FROM mesa as mesa WHERE mesa.numero_mesa = :numero";

    private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorError.class);

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
        return entityManager.find(MesaEntity.class,id);
    }

    @Override
    public List<Mesa> listarTodo() {
        Query query = entityManager.createQuery(FIND_ALL);
        ArrayList<Mesa> mesasDominio = new ArrayList<>();
        ArrayList<MesaEntity> mesas = (ArrayList<MesaEntity>) query.getResultList();
        for (MesaEntity mesa : mesas){
            mesasDominio.add(MesaBuilder.convertirADominio(mesa));
        }

        return mesasDominio;
    }

    @Override
    public void eliminar(int numeroMesa) {
        MesaEntity mesaEntity= obtenerMesaEntityPorNumero(numeroMesa);
        entityManager.remove(mesaEntity);
    }

    @Override
    public Mesa obtenerPorNumero(int numero) {
        try {
            MesaEntity mesaEntity = obtenerMesaEntityPorNumero(numero);
            return MesaBuilder.convertirADominio(mesaEntity);
        }catch (Exception e){
            LOGGER.info(e.toString());
            return null;
        }
    }

    private MesaEntity obtenerMesaEntityPorNumero(int numero) {

        try {
            Query query = entityManager.createQuery(FIND_BY_NUMERO);
            query.setParameter("numero", numero);

            return (MesaEntity) query.getSingleResult();
        }catch (Exception e){
            LOGGER.info(e.toString());
            return null;
        }
    }
}

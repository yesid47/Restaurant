package com.ceiba.restaurant.infraestructura.persistencia.repositorio;

import com.ceiba.restaurant.dominio.Mesa;
import com.ceiba.restaurant.dominio.dto.DtoMesa;
import com.ceiba.restaurant.dominio.repositorio.RepositorioMesa;
import com.ceiba.restaurant.infraestructura.persistencia.builder.MesaBuilder;
import com.ceiba.restaurant.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.restaurant.infraestructura.persistencia.repositorio.jpa.RepositorioMesaJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioMesaPersistente implements RepositorioMesa, RepositorioMesaJPA {
    private static final String FIND_ALL ="SELECT mesa FROM mesa as mesa";
    private static final String FIND_BY_NUMERO = "SELECT mesa FROM mesa as mesa WHERE mesa.numeroMesa = :numero";


    private EntityManager entityManager;

    public RepositorioMesaPersistente(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void agregar(Mesa mesa) {
        entityManager.persist(MesaBuilder.convertirAEntity(mesa));
    }

    @Override
    public DtoMesa obtenerPorId(int id) {
        MesaEntity mesaEntity = obtenerEntityPorId(id);
        return MesaBuilder.convertirADto(mesaEntity);
    }

    @Override
    public MesaEntity obtenerEntityPorId(int id) {
        return entityManager.find(MesaEntity.class,id);
    }


    @Override
    public List<DtoMesa> listarTodo() {
        Query query = entityManager.createQuery(FIND_ALL);
        ArrayList<MesaEntity> mesas = (ArrayList<MesaEntity>) query.getResultList();
        return MesaBuilder.convertirADominio(mesas);
    }

    @Override
    public void eliminar(int numeroMesa) {
        MesaEntity mesaEntity= obtenerEntityPorNumero(numeroMesa);
        entityManager.remove(mesaEntity);
    }

    @Override
    public DtoMesa obtenerPorNumero(int numero) {
        MesaEntity mesaEntity = obtenerEntityPorNumero(numero);
        return MesaBuilder.convertirADto(mesaEntity);
    }

    @Override
    public void actualizar(Mesa mesa) {

        entityManager.merge(MesaBuilder.convertirAEntity(mesa));

    }

    @Override
    public MesaEntity obtenerEntityPorNumero(int numero) {

            Query query = entityManager.createQuery(FIND_BY_NUMERO);
            query.setParameter("numero", numero);

            return (MesaEntity) query.getResultList().stream().findFirst().orElse(null);
    }
}

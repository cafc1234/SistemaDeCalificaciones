/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entity.CorteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Corte
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class CortePersistence {

    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;    


    /**
     * Metodo que trae todos los datos que se encuentran en la tabla corte
     * @return lista cortes
     */

    public List<CorteEntity> findAll(){
        Query query = entityManager.createQuery("select p from Corte p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto corte  mediante su id
     * @param id
     * @return corte encontrado
     */
    public CorteEntity find(Long id){
        return entityManager.find(CorteEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad corte
     * @param corteNuevo
     * @return corteNuevo
     */
    public CorteEntity create(CorteEntity corteNuevo){
        entityManager.persist(corteNuevo);
        return corteNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad corte
     * @param corteActualizar
     * @return corte actualizado
     */
    public CorteEntity update(CorteEntity corteActualizar){
        return entityManager.merge(corteActualizar);
    }
    
    /**
     * Metodo usado para eliminar un corte
     * @param id 
     */
    public void remove(Long id){
        CorteEntity corteEliminar = entityManager.find(CorteEntity.class, id);
        entityManager.remove(corteEliminar);
    }
}
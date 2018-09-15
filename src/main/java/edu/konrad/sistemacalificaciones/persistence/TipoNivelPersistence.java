/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;


import edu.konrad.sistemacalificaciones.entity.TipoNivelEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Tipo nivel
 * @author Evelyn Gúzman y Camilo Fique
 */

@Stateless
public class TipoNivelPersistence {
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;  
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla tipo curso
     * @return lista tipo curso
     */

    public List<TipoNivelEntity> findAll(){
        Query query = entityManager.createQuery("select p from TipoNivel p");
        return query.getResultList();
    }
    
    /**
     * Metodo para crear un objeto de la entidad tipoNivel
     * @param tipoNivelNuevo
     * @return tipoNivelNuevo
     */
    public TipoNivelEntity create(TipoNivelEntity tipoNivelNuevo){
        entityManager.persist(tipoNivelNuevo);
        return tipoNivelNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad tipoNivel
     * @param tipoNivelActualizar
     * @return tipoNivel actualizado
     */
    public TipoNivelEntity update(TipoNivelEntity tipoNivelActualizar){
        return entityManager.merge(tipoNivelActualizar);
    }
    
    /**
     * Metodo usado para eliminar un tipoNivel
     * @param id 
     */
    public void remove(Long id){
        TipoNivelEntity tipoNivelEliminar = entityManager.find(TipoNivelEntity.class, id);
        entityManager.remove(tipoNivelEliminar);
    }
}


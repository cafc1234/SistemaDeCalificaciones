/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entities.GrupoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Grupo
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class GrupoPersistence {
 
     /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;

    /**
     * Metodo que trae todos los datos que se encuentran en la tabla Grupo
     * @return lista grupo
     */

    public List<GrupoEntity> findAll(){
        Query query = entityManager.createQuery("select p from Grupo p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto grupo  mediante su id
     * @param id
     * @return grupo encontrado
     */
    public GrupoEntity find(Long id){
        return entityManager.find(GrupoEntity.class, id);
    }

       
    /**
     * Metodo para crear un objeto de la entidad grupo
     * @param grupoNuevo
     * @return grupoNuevo
     */
    public GrupoEntity create(GrupoEntity grupoNuevo){
        entityManager.persist(grupoNuevo);
        return grupoNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad grupo
     * @param grupoActualizar
     * @return grupo actualizado
     */
    public GrupoEntity update(GrupoEntity grupoActualizar){
        return entityManager.merge(grupoActualizar);
    }
    
    /**
     * Metodo usado para eliminar un grupo
     * @param id 
     */
    public void remove(Long id){
        GrupoEntity grupoEliminar = entityManager.find(GrupoEntity.class, id);
        entityManager.remove(grupoEliminar);
    }
    

}

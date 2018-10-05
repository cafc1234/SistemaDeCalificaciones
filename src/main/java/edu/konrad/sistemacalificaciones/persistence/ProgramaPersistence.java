/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entities.ProgramaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Programa
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class ProgramaPersistence {
 
     /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;

    /**
     * Metodo que trae todos los datos que se encuentran en la tabla Programa
     * @return lista programa
     */

    public List<ProgramaEntity> findAll(){
        Query query = entityManager.createQuery("select p from Programa p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto programa  mediante su id
     * @param id
     * @return programa encontrado
     */
    public ProgramaEntity find(Long id){
        return entityManager.find(ProgramaEntity.class, id);
    }

       
    /**
     * Metodo para crear un objeto de la entidad programa
     * @param programaNuevo
     * @return programaNuevo
     */
    public ProgramaEntity create(ProgramaEntity programaNuevo){
        entityManager.persist(programaNuevo);
        return programaNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad programa
     * @param programaActualizar
     * @return programa actualizado
     */
    public ProgramaEntity update(ProgramaEntity programaActualizar){
        return entityManager.merge(programaActualizar);
    }
    
    /**
     * Metodo usado para eliminar un programa
     * @param id 
     */
    public void remove(Long id){
        ProgramaEntity programaEliminar = entityManager.find(ProgramaEntity.class, id);
        entityManager.remove(programaEliminar);
    }
        
}

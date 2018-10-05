/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entities.ProfesorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Profesor
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class ProfesorPersistence {

    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;    

        /**
     * Metodo que trae todos los datos que se encuentran en la tabla Profesor
     * @return lista profesor
     */

    public List<ProfesorEntity> findAll(){
        Query query = entityManager.createQuery("select p from Profesor p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto profesor  mediante su id
     * @param id
     * @return profesor encontrado
     */
    public ProfesorEntity find(Long id){
        return entityManager.find(ProfesorEntity.class, id);
    }

       
    /**
     * Metodo para crear un objeto de la entidad profesor
     * @param profesorNuevo
     * @return profesorNuevo
     */
    public ProfesorEntity create(ProfesorEntity profesorNuevo){
        entityManager.persist(profesorNuevo);
        return profesorNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad profesor
     * @param profesorActualizar
     * @return profesor actualizado
     */
    public ProfesorEntity update(ProfesorEntity profesorActualizar){
        return entityManager.merge(profesorActualizar);
    }
    
    /**
     * Metodo usado para eliminar un profesor
     * @param id 
     */
    public void remove(Long id){
        ProfesorEntity profesorEliminar = entityManager.find(ProfesorEntity.class, id);
        entityManager.remove(profesorEliminar);
    }
    
}

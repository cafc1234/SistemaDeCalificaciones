/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entities.RolEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Rol
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class RolPersistence {
     /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;

    /**
     * Metodo que trae todos los datos que se encuentran en la tabla Rol
     * @return lista rol
     */

    public List<RolEntity> findAll(){
        Query query = entityManager.createQuery("select p from Rol p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto rol  mediante su id
     * @param id
     * @return rol encontrado
     */
    public RolEntity find(Long id){
        return entityManager.find(RolEntity.class, id);
    }

       
    /**
     * Metodo para crear un objeto de la entidad rol
     * @param rolNuevo
     * @return rolNuevo
     */
    public RolEntity create(RolEntity rolNuevo){
        entityManager.persist(rolNuevo);
        return rolNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad rol
     * @param rolActualizar
     * @return rol actualizado
     */
    public RolEntity update(RolEntity rolActualizar){
        return entityManager.merge(rolActualizar);
    }
    
    /**
     * Metodo usado para eliminar un rol
     * @param id 
     */
    public void remove(Long id){
        RolEntity rolEliminar = entityManager.find(RolEntity.class, id);
        entityManager.remove(rolEliminar);
    }
    
}

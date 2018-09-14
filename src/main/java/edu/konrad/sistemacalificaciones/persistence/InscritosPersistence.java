/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entity.InscritosEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Inscritos
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class InscritosPersistence {
     /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;    
 
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla Inscritos
     * @return lista inscritos
     */

    public List<InscritosEntity> findAll(){
        Query queryProducto = entityManager.createQuery("select p from Inscritos p");
        return queryProducto.getResultList();
    }
    
    /**
     * Metodo que busca un objeto inscritos  mediante su id
     * @param id
     * @return inscrito encontrado
     */
    public InscritosEntity find(Long id){
        return entityManager.find(InscritosEntity.class, id);
    }

       
    /**
     * Metodo para crear un objeto de la entidad inscritos
     * @param inscritosNuevo
     * @return inscritosNuevo
     */
    public InscritosEntity create(InscritosEntity inscritosNuevo){
        entityManager.persist(inscritosNuevo);
        return inscritosNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad inscritos
     * @param inscritosActualizar
     * @return inscrito actualizado
     */
    public InscritosEntity update(InscritosEntity inscritosActualizar){
        return entityManager.merge(inscritosActualizar);
    }
    
    /**
     * Metodo usado para eliminar un inscrito
     * @param id 
     */
    public void remove(Long id){
        InscritosEntity inscritosEliminar = entityManager.find(InscritosEntity.class, id);
        entityManager.remove(inscritosEliminar);
    }

}

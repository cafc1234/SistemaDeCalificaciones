/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entities.NotasEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Notas
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class NotasPersistence {
     /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesUP")
    private EntityManager entityManager;    

     /**
     * Metodo que trae todos los datos que se encuentran en la tabla Notas
     * @return lista notas
     */

    public List<NotasEntity> findAll(){
        Query query = entityManager.createQuery("select p from Notas p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto notas  mediante su id
     * @param id
     * @return nota encontrada
     */
    public NotasEntity find(int id){
        return entityManager.find(NotasEntity.class, id);
    }

       
    /**
     * Metodo para crear un objeto de la entidad notas
     * @param notasNueva
     * @return notasNueva
     */
    public NotasEntity create(NotasEntity notasNueva){
        entityManager.persist(notasNueva);
        return notasNueva;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad notas
     * @param notasActualizar
     * @return nota actualizada
     */
    public NotasEntity update(NotasEntity notasActualizar){
        return entityManager.merge(notasActualizar);
    }
    
    /**
     * Metodo usado para eliminar una nota
     * @param id 
     */
    public void remove(int id){
        NotasEntity notasEliminar = entityManager.find(NotasEntity.class, id);
        entityManager.remove(notasEliminar);
    }
}

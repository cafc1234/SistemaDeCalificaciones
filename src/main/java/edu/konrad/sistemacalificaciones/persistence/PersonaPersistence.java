/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entities.PersonaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Persona
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class PersonaPersistence {
      /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;    
  
     /**
     * Metodo que trae todos los datos que se encuentran en la tabla Persona
     * @return lista persona
     */

    public List<PersonaEntity> findAll(){
        Query query = entityManager.createQuery("select p from Persona p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto persona  mediante su id
     * @param id
     * @return persona encontrada
     */
    public PersonaEntity find(int id){
        return entityManager.find(PersonaEntity.class, id);
    }

       
    /**
     * Metodo para crear un objeto de la entidad persona
     * @param personaNueva
     * @return personaNueva
     */
    public PersonaEntity create(PersonaEntity personaNueva){
        entityManager.persist(personaNueva);
        return personaNueva;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad persona
     * @param personaActualizar
     * @return persona actualizada
     */
    public PersonaEntity update(PersonaEntity personaActualizar){
        return entityManager.merge(personaActualizar);
    }
    
    /**
     * Metodo usado para eliminar una persona
     * @param id 
     */
    public void remove(int id){
        PersonaEntity personaEliminar = entityManager.find(PersonaEntity.class, id);
        entityManager.remove(personaEliminar);
    }
}

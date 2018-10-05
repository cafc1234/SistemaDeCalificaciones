/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entities.CursoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Curso
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class CursoPersistence {

    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;    
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla Curso
     * @return lista curso
     */

    public List<CursoEntity> findAll(){
        Query query = entityManager.createQuery("select p from Curso p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto curso  mediante su id
     * @param id
     * @return curso encontrado
     */
    public CursoEntity find(Long id){
        return entityManager.find(CursoEntity.class, id);
    }

       
    /**
     * Metodo para crear un objeto de la entidad curso
     * @param cursoNuevo
     * @return cursoNuevo
     */
    public CursoEntity create(CursoEntity cursoNuevo){
        entityManager.persist(cursoNuevo);
        return cursoNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad curso
     * @param cursoActualizar
     * @return curso actualizado
     */
    public CursoEntity update(CursoEntity cursoActualizar){
        return entityManager.merge(cursoActualizar);
    }
    
    /**
     * Metodo usado para eliminar un curso
     * @param id 
     */
    public void remove(Long id){
        CursoEntity cursoEliminar = entityManager.find(CursoEntity.class, id);
        entityManager.remove(cursoEliminar);
    }
}

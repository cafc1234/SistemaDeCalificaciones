/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;


import edu.konrad.sistemacalificaciones.entities.TipoCursoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *Clase manejadora de la transaccionalidad de la entidad Tipo curso
 * @author Evelyn Gúzman y Camilo Fique
 */

@Stateless
public class TipoCursoPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;  
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla tipo curso
     * @return lista tipo curso
     */

    public List<TipoCursoEntity> findAll(){
        Query query = entityManager.createQuery("select p from TipoCurso p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto tipo curso  mediante su id
     * @param id
     * @return tipo curso encontrado
     */
    public TipoCursoEntity find(Long id){
        return entityManager.find(TipoCursoEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad tipo curso
     * @param tipoCursoNuevo
     * @return tipoCursoNuevo
     */
    public TipoCursoEntity create(TipoCursoEntity tipoCursoNuevo){
        entityManager.persist(tipoCursoNuevo);
        return tipoCursoNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad tipo curso
     * @param tipoCursoActualizar
     * @return tipoCurso actualizado
     */
    public TipoCursoEntity update(TipoCursoEntity tipoCursoActualizar){
        return entityManager.merge(tipoCursoActualizar);
    }
    
    /**
     * Metodo usado para eliminar un tipoCurso
     * @param id 
     */
    public void remove(Long id){
        TipoCursoEntity tipoCursoEliminar = entityManager.find(TipoCursoEntity.class, id);
        entityManager.remove(tipoCursoEliminar);
    }
}

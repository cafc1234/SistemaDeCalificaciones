package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entities.HorariosEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase manejadora de la transaccionalidad de la entidad Horarios
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless
public class HorariosPersistence {
       /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;    
 
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla Horarios
     * @return lista horarios
     */

    public List<HorariosEntity> findAll(){
        Query query = entityManager.createQuery("select p from Horarios p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto horario  mediante su id
     * @param id
     * @return horario encontrado
     */
    public HorariosEntity find(int id){
        return entityManager.find(HorariosEntity.class, id);
    }

       
    /**
     * Metodo para crear un objeto de la entidad horarios
     * @param horariosNuevo
     * @return horariosNuevo
     */
    public HorariosEntity create(HorariosEntity horariosNuevo){
        entityManager.persist(horariosNuevo);
        return horariosNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad horarios
     * @param horariosActualizar
     * @return horario actualizado
     */
    public HorariosEntity update(HorariosEntity horariosActualizar){
        return entityManager.merge(horariosActualizar);
    }
    
    /**
     * Metodo usado para eliminar un horario
     * @param id 
     */
    public void remove(int id){
        HorariosEntity horariosEliminar = entityManager.find(HorariosEntity.class, id);
        entityManager.remove(horariosEliminar);
    }


}

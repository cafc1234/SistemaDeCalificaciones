package edu.konrad.sistemacalificaciones.persistence;


import edu.konrad.sistemacalificaciones.entity.CuentaEntity;
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
 * Clase manejadora de la transaccionalidad de la entidad Cuenta
 * @author Evelyn Gúzman y Camilo Fique
 */ 
@Stateless

public class CuentaPersistence {
    
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;    


    /**
     * Metodo que trae todos los datos que se encuentran en la tabla cuenta
     * @return lista cuenta
     */

    public List<CuentaEntity> findAll(){
        Query query = entityManager.createQuery("select p from Cuenta p");
        return query.getResultList();
    }
    
    /**
     * Metodo que busca un objeto cuenta  mediante su id
     * @param id
     * @return cuenta encontrada
     */
    public CuentaEntity find(Long id){
        return entityManager.find(CuentaEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad cuenta
     * @param cuentaNueva
     * @return cuentaNueva
     */
    public CuentaEntity create(CuentaEntity cuentaNueva){
        entityManager.persist(cuentaNueva);
        return cuentaNueva;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad cuenta
     * @param cuentaActualizar
     * @return cuenta actualizada
     */
    public CuentaEntity update(CuentaEntity cuentaActualizar){
        return entityManager.merge(cuentaActualizar);
    }
    
    /**
     * Metodo usado para eliminar una cuenta
     * @param id 
     */
    public void remove(Long id){
        CuentaEntity cuentaEliminar = entityManager.find(CuentaEntity.class, id);
        entityManager.remove(cuentaEliminar);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.persistence;

import edu.konrad.sistemacalificaciones.entities.TipoDocumentoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase manejadora de la transaccionalidad de la entidad Tipo documento
 * @author Evelyn Gúzman y Camilo Fique
 */

@Stateless
public class TipoDocumentoPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "calificacionesPU")
    private EntityManager entityManager;  
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla tipo documento
     * @return lista tipo documento
     */

    public List<TipoDocumentoEntity> findAll(){
        Query query = entityManager.createQuery("select p from TipoDocumento p");
        return query.getResultList();
    }
    
            /**
     * Metodo que busca un objeto TipoNivel  mediante su id
     * @param id
     * @return corte encontrado
     */
    public TipoDocumentoEntity find(int id){
        return entityManager.find(TipoDocumentoEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad tipoDocumento
     * @param tipoDocumentoNuevo
     * @return tipoDocumentoNuevo
     */
    public TipoDocumentoEntity create(TipoDocumentoEntity tipoDocumentoNuevo){
        entityManager.persist(tipoDocumentoNuevo);
        return tipoDocumentoNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad tipoDocumento
     * @param tipoDocumentoActualizar
     * @return tipoDocumento actualizado
     */
    public TipoDocumentoEntity update(TipoDocumentoEntity tipoDocumentoActualizar){
        return entityManager.merge(tipoDocumentoActualizar);
    }
    
    /**
     * Metodo usado para eliminar un tipoDocumento
     * @param id 
     */
    public void remove(int id){
        TipoDocumentoEntity tipoDocumentoEliminar = entityManager.find(TipoDocumentoEntity.class, id);
        entityManager.remove(tipoDocumentoEliminar);
    }
}

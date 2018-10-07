/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.TipoNivelEntity;
import edu.konrad.sistemacalificaciones.persistence.TipoNivelPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de TipoNivel
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless

public class TipoNivelLogic {


    /**
     * Inyeccion del persistence de TipoNivel
     */
    @Inject
    private TipoNivelPersistence tipoNivelPersistence;
    
     /**
     * Obtener todos los objetos Tipo nivel
     *
     * @return
     */

    public List<TipoNivelEntity> obtenerTipoNivel() {
        List<TipoNivelEntity> tiposNivel = tipoNivelPersistence.findAll();
        return tiposNivel;
    }
    
     /**
     * Obtener un tipoNivel por su id
     *
     * @param id
     * @return TipoNivelEntity
     */

    public TipoNivelEntity obtenerTipoNivel(int id) {
        TipoNivelEntity tipoNivel = tipoNivelPersistence.find(id);
        if (tipoNivel == null) {
            throw new IllegalArgumentException("El tipoNivel solicitado NO existe");
        }
        return tipoNivel;
    }

     /**
     * Metodo que conecta la logica con la transaccion para crear un tipo curso
     *
     * @param tipoNivelCrear
     * @return tipo nivel creado
     */
    public TipoNivelEntity crearTipoNivel(TipoNivelEntity tipoNivelCrear) {
        tipoNivelPersistence.create(tipoNivelCrear);
        return tipoNivelCrear;
    }
    
     /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * tipoNivel
     *
     * @param id
     * @param tipoNivelActualizar
     * @return tipoNivel actualizado
     */
    public TipoNivelEntity actualizarTipoNivel(int id, TipoNivelEntity tipoNivelActualizar) {
        TipoNivelEntity tipoNivelUpdate = tipoNivelPersistence.update(tipoNivelActualizar);
        return tipoNivelUpdate;
    }

    /**
     * Metodo para eliminar un objeto TipoNivel
     *
     * @param id
     */
    public void eliminarTipoNivel(int id) {
        tipoNivelPersistence.remove(id);
    }


    
}

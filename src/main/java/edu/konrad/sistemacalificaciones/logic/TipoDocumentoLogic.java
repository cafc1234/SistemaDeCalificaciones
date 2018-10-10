/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.TipoDocumentoEntity;
import edu.konrad.sistemacalificaciones.persistence.TipoDocumentoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de TipoDocumento
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless

public class TipoDocumentoLogic {
    /**
     * Inyeccion del persistence de TipoDocumento
     */
    @Inject
    private TipoDocumentoPersistence tipoDocumentoPersistence;
    
     /**
     * Obtener todos los objetos Tipo Documento
     *
     * @return
     */

    public List<TipoDocumentoEntity> obtenerTipoDocumento() {
        List<TipoDocumentoEntity> tiposDocumento = tipoDocumentoPersistence.findAll();
        return tiposDocumento;
    }
    
     /**
     * Obtener un tipoDocumento por su id
     *
     * @param id
     * @return TipoDocumentoEntity
     */

    public TipoDocumentoEntity obtenerTipoDocumento(int id) {
        TipoDocumentoEntity tipoDocumento = tipoDocumentoPersistence.find(id);
        if (tipoDocumento == null) {
            throw new IllegalArgumentException("El tipoDocumento solicitado NO existe");
        }
        return tipoDocumento;
    }

     /**
     * Metodo que conecta la logica con la transaccion para crear un tipo curso
     *
     * @param tipoDocumentoCrear
     * @return tipo documento creado
     */
    public TipoDocumentoEntity crearTipoDocumento(TipoDocumentoEntity tipoDocumentoCrear) {
        tipoDocumentoPersistence.create(tipoDocumentoCrear);
        return tipoDocumentoCrear;
    }
    
     /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * tipoDocumento
     *
     * @param id
     * @param tipoDocumentoActualizar
     * @return tipoDocumento actualizado
     */
    public TipoDocumentoEntity actualizarTipoDocumento(int id, TipoDocumentoEntity tipoDocumentoActualizar) {
        TipoDocumentoEntity tipoDocumentoUpdate = tipoDocumentoPersistence.update(tipoDocumentoActualizar);
        return tipoDocumentoUpdate;
    }

    /**
     * Metodo para eliminar un objeto TipoDocumento
     *
     * @param id
     */
    public void eliminarTipoDocumento(int id) {
        tipoDocumentoPersistence.remove(id);
    }


    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.TipoDocumentoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad TipoDocumento
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class TipoDocumentoDTO {
     /**
     * Atributo que hace referencia al id del objeto tipo documento
     */
    private int id;

    /**
     * Atributo que hace referencia al nombre del objeto tipo documento
     */
    private String nombreTipo;

    /**
     * Constructor vacio
     */
    
    public TipoDocumentoDTO(){
    }
    
    public TipoDocumentoDTO(TipoDocumentoEntity tipoDocumentoEntity){
    this.id=tipoDocumentoEntity.getIdTipo();
    this.nombreTipo=tipoDocumentoEntity.getNombreTipo();
    }
    
    public TipoDocumentoEntity toEntity(){
    TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity();
    tipoDocumentoEntity.setIdTipo(this.id);
    tipoDocumentoEntity.setNombreTipo(this.nombreTipo);
    return tipoDocumentoEntity;
    }
    
        /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaTiposDocumento
     * @return
     */
    public static List<TipoDocumentoDTO> toTipoDocumentoList(List<TipoDocumentoEntity> listaTiposDocumento) {
        List<TipoDocumentoDTO> listaTipoDocumentoDTO = new ArrayList<>();
        for (TipoDocumentoEntity entity : listaTiposDocumento) {
            listaTipoDocumentoDTO.add(new TipoDocumentoDTO(entity));
        }
        return listaTipoDocumentoDTO;
    }

    
}

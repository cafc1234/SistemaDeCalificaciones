/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.TipoNivelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad TipoNivel
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class TipoNivelDTO {

    /**
     * Atributo que hace referencia al id del objeto tipo nivel
     */
    private int id;

    /**
     * Atributo que hace referencia al nombre del objeto tipo nivel
     */
    private String nombreNivel;

    /**
     * Constructor vacio
     */
    public TipoNivelDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param tipoNivelEntity
     */
    
    public TipoNivelDTO(TipoNivelEntity tipoNivelEntity){
    this.id=tipoNivelEntity.getIdTipo();
    this.nombreNivel=tipoNivelEntity.getNombreNivel();
    
}
    
     /**
     * Transformacion objeto - entidad
     *
     * @return tipoNivelEntity
     */

public TipoNivelEntity toEntity(){
TipoNivelEntity tipoNivelEntity = new TipoNivelEntity();
tipoNivelEntity.setIdTipo(this.id);
tipoNivelEntity.setNombreNivel(this.nombreNivel);
return tipoNivelEntity;
}

    /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaTiposNivel
     * @return
     */
    public static List<TipoNivelDTO> toTipoNivelList(List<TipoNivelEntity> listaTiposNivel) {
        List<TipoNivelDTO> listaTipoNivelDTO = new ArrayList<>();
        for (TipoNivelEntity entity : listaTiposNivel) {
            listaTipoNivelDTO.add(new TipoNivelDTO(entity));
        }
        return listaTipoNivelDTO;
    }

  
    /**
     * Metodos GET y SET
     */ 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }
    

}



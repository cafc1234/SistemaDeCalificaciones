/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.TipoCursoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Grupo
 *
 * @author Evelyn Guzman y Camilo Fique
 */
public class TipoCursoDTO {

    /**
     * Atributo que hace referencia al atributo ID del objeto tipo curso
     */
    private int id;

    /**
     * Atributo que hace referencia al nombre del objeto tipo_curso
     */
    private String nombreCurso;

    /**
     * Constructor vacio
     */
    public TipoCursoDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param tipoCursoEntity
     */
    public TipoCursoDTO(TipoCursoEntity tipoCursoEntity) {
        this.id = tipoCursoEntity.getIdTipo();
        this.nombreCurso = tipoCursoEntity.getNombreCurso();
    }

    /**
     * Transformacion objeto - entidad
     *
     * @return CorteEntity
     */
    public TipoCursoEntity toEntity() {
        TipoCursoEntity tipoCursoEntity = new TipoCursoEntity();
        tipoCursoEntity.setIdTipo(this.id);
        tipoCursoEntity.setNombreCurso(this.nombreCurso);
        return tipoCursoEntity;
    }

    /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaTipoCursos
     * @return
     */

    public static List<TipoCursoDTO> toTipoCursoList(List<TipoCursoEntity> listaTipoCursos) {
        List<TipoCursoDTO> listaTipoCursosDTO = new ArrayList<>();
        for (TipoCursoEntity tipoCursoEntity : listaTipoCursos) {
            listaTipoCursosDTO.add(new TipoCursoDTO(tipoCursoEntity));
        }
        return listaTipoCursosDTO;
    }
    
    /**
     * Metodos GET y SET de la clase
     *  
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    
}

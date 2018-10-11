/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.CursoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Persona
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class CursoDTO {

    /**
     * Atributo que hace referencia al ID del curso
     */
    private int id;

    /**
     * Atributo que hace referencia al nombre del curso
     */
    private String nombreCurso;

    /**
     * Atributo que hace referencia al tipo de curso y relaciona con TipoCurso
     */
    private TipoCursoDTO tipoCurso;

    /**
     * Atributo que hace referencia al id del grupo y se relaciona con grupo
     */
    private GrupoDTO grupo;

    /**
     * Atirbuto que hace referencia al profesor del curso
     */
    private ProfesorDTO profesor;

    /**
     * Atributo que hace referencia al tipo nivel del curso y se relaciona con
     * tipo nivel
     */
    private TipoNivelDTO tipoNivel;

    /**
     * Constructor vacio
     */
    public CursoDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param cursoEntity
     */
    public CursoDTO(CursoEntity cursoEntity) {
        this.id = cursoEntity.getIdCurso();
        this.nombreCurso = cursoEntity.getNombreCurso();
        if (cursoEntity.getTipo() != null) {
            this.tipoCurso = new TipoCursoDTO(cursoEntity.getTipo());
        }
        if (cursoEntity.getGrupo() != null) {
            this.grupo = new GrupoDTO(cursoEntity.getGrupo());
        }
        if (cursoEntity.getProfesor() != null) {
            this.profesor = new ProfesorDTO(cursoEntity.getProfesor());
        }
        if (cursoEntity.getNivel() != null) {
            this.tipoNivel = new TipoNivelDTO(cursoEntity.getNivel());
        }

    }

    /**
     * Transformacion objeto - entidad
     *
     *
     * @return CursoEntity
     */
    public CursoEntity toEntity() {
        CursoEntity cursoEntity = new CursoEntity();
        cursoEntity.setIdCurso(this.id);
        cursoEntity.setNombreCurso(this.nombreCurso);
        if (this.tipoCurso != null) {
            cursoEntity.setTipo(this.tipoCurso.toEntity());
        }
        if (this.grupo != null) {
            cursoEntity.setGrupo(this.grupo.toEntity());
        }
        if (this.profesor != null) {
            cursoEntity.setProfesor(this.profesor.toEntity());
        }
        if (this.tipoNivel != null) {
            cursoEntity.setNivel(this.tipoNivel.toEntity());
        }
        return cursoEntity;

    }

    /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaCursos
     * @return
     */
    public static List<CursoDTO> toCursosList(List<CursoEntity> listaCursos) {
        List<CursoDTO> listaCursosDTO = new ArrayList<>();
        for (CursoEntity entity : listaCursos) {
            listaCursosDTO.add(new CursoDTO(entity));
        }
        return listaCursosDTO;
    }

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

    public TipoCursoDTO getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCursoDTO tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public GrupoDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDTO grupo) {
        this.grupo = grupo;
    }

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
    }

    public TipoNivelDTO getTipoNivel() {
        return tipoNivel;
    }

    public void setTipoNivel(TipoNivelDTO tipoNivel) {
        this.tipoNivel = tipoNivel;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.InscritosEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Inscritos
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class InscritosDTO {

    /**
     * Atributo que hace referencia al id de inscritos
     */
    private int id;

    /**
     * Atributo que hace referencia al grupo y curso se relaciona con grupo
     */
    private CursoDTO grupo;

    /**
     * Atributo que hace referencia al codigo del estudiante
     */
    private PersonaDTO estudiante;

    /**
     * Constructor vacio
     */
    public InscritosDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param inscritosEntity
     */
    public InscritosDTO(InscritosEntity inscritosEntity) {
        this.id = inscritosEntity.getIdInscrito();
        if (inscritosEntity.getGrupo() != null) {
            this.grupo = new CursoDTO(inscritosEntity.getGrupo());
        }
        if (inscritosEntity.getEstudiante() != null) {
            this.estudiante = new PersonaDTO(inscritosEntity.getEstudiante());
        }
    }

    /**
     * Transformacion objeto - entidad
     *
     *
     * @return InscritosEntity
     */
    public InscritosEntity toEntity() {
        InscritosEntity inscritosEntity = new InscritosEntity();
        inscritosEntity.setIdInscrito(this.id);
        if (this.grupo != null) {
            inscritosEntity.setGrupo(this.grupo.toEntity());
        }
        if (this.estudiante != null) {
            inscritosEntity.setEstudiante(this.estudiante.toEntity());
        }
        return inscritosEntity;
    }

    /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaInscritos
     * @return
     */
    public static List<InscritosDTO> toInscritosList(List<InscritosEntity> listaInscritos) {
        List<InscritosDTO> listaInscritosDTO = new ArrayList<>();
        for (InscritosEntity entity : listaInscritos) {
            listaInscritosDTO.add(new InscritosDTO(entity));
        }
        return listaInscritosDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CursoDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(CursoDTO grupo) {
        this.grupo = grupo;
    }

    public PersonaDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(PersonaDTO estudiante) {
        this.estudiante = estudiante;
    }

}

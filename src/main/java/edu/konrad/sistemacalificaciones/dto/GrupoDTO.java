/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.GrupoEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *Clase encargada del mapeo objeto relacional de la entidad Grupo
 *
 * @author Evelyn Guzman y Camilo Fique
 */
public class GrupoDTO {
    /**
     * Atributo que hace referencia al id del objeto grupo
     */
    private int id;

    /**
     * Atributo que hace referencia al nombre del objeto grupo
     */
    private String nombreGrupo;

    /*
     * Constructor por defecto
     */
    public GrupoDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param grupoEntity
     */
    public GrupoDTO(GrupoEntity grupoEntity) {
        this.id = grupoEntity.getIdGrupo();
        this.nombreGrupo = grupoEntity.getNombreGrupo();
    }

    /**
     * Transformacion objeto - entidad
     *
     * @return GrupoEntity
     */
    public GrupoEntity toEntity() {
        GrupoEntity grupoEntity = new GrupoEntity();
        grupoEntity.setIdGrupo(this.id);
        grupoEntity.setNombreGrupo(this.nombreGrupo);
        return grupoEntity;
    }

    /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaGrupos
     * @return
     */
    public static List<GrupoDTO> toGrupoList(List<GrupoEntity> listaGrupos) {
        List<GrupoDTO> listaGrupoDTO = new ArrayList<>();
        for (GrupoEntity entity : listaGrupos) {
            listaGrupoDTO.add(new GrupoDTO(entity));
        }
        return listaGrupoDTO;
    }

    /**
     * Metodos Get y Set de la clase
     */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
}

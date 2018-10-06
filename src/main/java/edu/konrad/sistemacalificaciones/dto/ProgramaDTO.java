/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Programa
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class ProgramaDTO {

    /**
     * Atributo que hace referencia al id del objeto programa
     */
    private int id;

    /**
     * Atributo que hace referencia al nombre del objeto programa
     */
    private String nombrePrograma;

    /**
     * COnstructor por defecto
     */
    public ProgramaDTO() {
    }

    /**
     * Transformación entidad - objeto
     *
     * @param programaEntity
     */
    public ProgramaDTO(ProgramaEntity programaEntity) {
        this.id = programaEntity.getIdPrograma();
        this.nombrePrograma = programaEntity.getNombrePrograma();
    }

    /**
     * Transformacion objeto - entidad
     *
     * @return ProgramaEntity
     */
    public ProgramaEntity toEntity() {
        ProgramaEntity programaEntity = new ProgramaEntity();
        programaEntity.setIdPrograma(this.id);
        programaEntity.setNombrePrograma(this.nombrePrograma);
        return programaEntity;
    }

    /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaProgramas
     * @return
     */
    public static List<ProgramaDTO> toProgramasList(List<ProgramaEntity> listaProgramas) {
        List<ProgramaDTO> listaProgramaDTO = new ArrayList<>();
        for (ProgramaEntity programaEntity : listaProgramas) {
            listaProgramaDTO.add(new ProgramaDTO(programaEntity));
        }
        return listaProgramaDTO;

    }

    /**
     * Metodos get y set de la clase
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.ProfesorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Profesor
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class ProfesorDTO {

    /**
     * Atributo que hace referencia al ID del profesor
     */
    private int id;

    /**
     * Atributo que hace referencia al código del profesor y se relaciona con
     * persona
     */
    private PersonaDTO codigo;

    /**
     * Atributo que hace referencia al área de profundización
     */
    private String areaProfundizacion;

    /**
     * Constructor vacio
     */
    public ProfesorDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param profesorEntity
     */
    public ProfesorDTO(ProfesorEntity profesorEntity) {
        this.id = profesorEntity.getIdProfesor();
        if (profesorEntity.getCodigo() != null) {
            this.codigo = new PersonaDTO(profesorEntity.getCodigo());
        }
        this.areaProfundizacion = profesorEntity.getAreaProfundizacion();
    }

    /**
     * Transformacion objeto - entidad
     *
     *
     * @return ProfesorEntity
     */

    public ProfesorEntity toEntity() {
        ProfesorEntity profesorEntity = new ProfesorEntity();
        profesorEntity.setIdProfesor(this.id);
        if (this.codigo != null) {
            profesorEntity.setCodigo(this.codigo.toEntity());
        }
        profesorEntity.setAreaProfundizacion(this.areaProfundizacion);
        return profesorEntity;
    }


     /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaProfesores
     * @return
     */
    
        public static List<ProfesorDTO> toProfesorList(List<ProfesorEntity> listaProfesores) {
        List<ProfesorDTO> listaProfesoresDTO = new ArrayList<>();
        for (ProfesorEntity entity : listaProfesores) {
            listaProfesoresDTO.add(new ProfesorDTO(entity));
        }
        return listaProfesoresDTO;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonaDTO getCodigo() {
        return codigo;
    }

    public void setCodigo(PersonaDTO codigo) {
        this.codigo = codigo;
    }

    public String getAreaProfundizacion() {
        return areaProfundizacion;
    }

    public void setAreaProfundizacion(String areaProfundizacion) {
        this.areaProfundizacion = areaProfundizacion;
    }
        
        
}
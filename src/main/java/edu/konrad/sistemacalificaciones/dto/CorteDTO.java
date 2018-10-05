/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.CorteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Producto
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class CorteDTO {

    /**
     * Atributo que hace referencia al id del objeto corte
     */
    private int id;

    /**
     * Atributo que hace referencia al nombre del objeto corte
     */
    private String nombreCorte;

    /**
     * Constructor por defecto
     */
    public CorteDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param corteEntity
     */
    public CorteDTO(CorteEntity corteEntity) {
        this.id = corteEntity.getIdCorte();
        this.nombreCorte = corteEntity.getNombreCorte();

    }

    /**
     * Transformacion objeto - entidad
     *
     * @return CorteEntity
     */
    public CorteEntity toEntity() {
        CorteEntity entity = new CorteEntity();
        entity.setIdCorte(this.id);
        entity.setNombreCorte(this.nombreCorte);
        return entity;
    }

    /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaCortes
     * @return
     */
    public static List<CorteDTO> toProductoList(List<CorteEntity> listaCortes) {
        List<CorteDTO> listaCorteDTO = new ArrayList<>();
        for (CorteEntity entity : listaCortes) {
            listaCorteDTO.add(new CorteDTO(entity));
        }
        return listaCorteDTO;
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

    public String getNombreCorte() {
        return nombreCorte;
    }

    public void setNombreCorte(String nombreCorte) {
        this.nombreCorte = nombreCorte;
    }

}

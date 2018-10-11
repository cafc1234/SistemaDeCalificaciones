/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.NotasEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Notas
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class NotasDTO {

    /**
     * Atributo que hace referencia al id de notas
     */
    private int id;

    /**
     * Atributo que hace referencia al id del grupo, curso y estudiante al que
     * se le asignará una nota
     */
    private InscritosDTO inscrito;

    /**
     * Atributo que hace referencia a la nota del estudiante
     */
    private double valorNota;

    /**
     * Constructor vacio
     */
    public NotasDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param notasEntity
     */
    public NotasDTO(NotasEntity notasEntity) {
        this.id = notasEntity.getIdNota();
        if (notasEntity.getGrupo() != null) {
            this.inscrito = new InscritosDTO(notasEntity.getGrupo());
        }
        this.valorNota = notasEntity.getIdNota();

    }

    /**
     * Transformacion objeto - entidad
     *
     *
     * @return NotasEntity
     */
    public NotasEntity toEntity() {
        NotasEntity notasEntity = new NotasEntity();
        notasEntity.setIdNota(this.id);
        if (this.inscrito != null) {
            notasEntity.setGrupo(this.inscrito.toEntity());
        }
        notasEntity.setValorNota(this.valorNota);
        return notasEntity;
    }
    
        /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaNotas
     * @return
     */
    public static List<NotasDTO> toNotasList(List<NotasEntity> listaNotas) {
        List<NotasDTO> listaNotasDTO = new ArrayList<>();
        for (NotasEntity entity : listaNotas) {
            listaNotasDTO.add(new NotasDTO(entity));
        }
        return listaNotasDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InscritosDTO getInscrito() {
        return inscrito;
    }

    public void setInscrito(InscritosDTO inscrito) {
        this.inscrito = inscrito;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }
    
    


}

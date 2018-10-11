/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase encargada de crear la entidad de la tabla notas
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name = "Notas")
public class NotasEntity implements Serializable {

    /**
     * Llave primaria de la entidad notas
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idNota;

    /**
     * Columna que hace referencia al id del grupo, del curso y el estudiante y
     * se relaciona con la tabla Notas
     */
    @ManyToOne
    @JoinColumn(name = "idGrupo")
    private InscritosEntity grupo;

    /**
     * Columna que hace referencia al valor de la nota
     */
    @Column(name = "valor_nota", nullable = false)
    private double valorNota;

    /**
     * Métodos GET Y SET
     */
    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public InscritosEntity getGrupo() {
        return grupo;
    }

    public void setGrupo(InscritosEntity grupo) {
        this.grupo = grupo;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }

}

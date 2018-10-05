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

/**
 * Clase encargada de crear la entidad de la tabla categórica Tipo curso
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name="TipoCurso")
public class TipoCursoEntity implements Serializable{
    
    /**
     * Llave primaria de la entidad TipoDocumento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTipo;    
    
     /**
     * Columna que hace referencia al nombre del tipo de curso
     */
    @Column(name = "nombre_curso", nullable = false)
    private String nombreCurso;


    
    /**
     * Métodos GET y SET
     */
    
    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }    
}

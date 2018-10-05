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
 * Clase encargada de crear la entidad de la tabla categórica Tipo nivel
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name="TipoNivel")
public class TipoNivelEntity implements Serializable {
    
    /**
     * Llave primaria de la entidad TipoDocumento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTipo;    
    
     /**
     * Columna que hace referencia al nombre del tipo de curso
     */
    @Column(name = "nombre_nivel", nullable = false)
    private String nombreNivel;

    /**
     * Métodos GET y SET
     */
    
    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }
    
    
 
    
}

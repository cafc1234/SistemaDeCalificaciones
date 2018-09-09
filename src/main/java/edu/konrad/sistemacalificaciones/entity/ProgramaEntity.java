/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase encargada de crear la entidad de la tabla Programa
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name = "Programa")
public class ProgramaEntity implements Serializable {

    /**
     * Llave primaria de la entidad Programa
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPrograma;

    /**
     * Columna que hace referencia al nombre del programa
     */
    @Column(name = "nombre_Programa", nullable = false)
    private String nombrePrograma;

    /**
     * Métodos GET Y SET
     */
    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

}

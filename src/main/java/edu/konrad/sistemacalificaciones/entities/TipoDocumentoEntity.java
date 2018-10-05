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
 * Clase encargada de crear la entidad de la tabla categórica Tipo documento
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name = "TipoDocumento")
public class TipoDocumentoEntity implements Serializable {

    /**
     * Llave primaria de la entidad TipoDocumento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTipo;

    /**
     * Columna que hace referencia al nombre del tipo de documento
     */
    @Column(name = "nombre_tipo", nullable = false)
    private String nombreTipo;

    /**
     * Métodos GET y SET
     */
    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

}

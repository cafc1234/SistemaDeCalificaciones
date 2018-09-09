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
 * Clase encargada de crear la entidad Corte
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name="Corte")
public class CorteEntity implements Serializable{

    /**
     * Llave primaria de la entidad TipoDocumento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCorte;
    
     /**
     * Columna que hace referencia al nombre del corte
     */
    @Column(name = "nombre_corte", nullable = false)
    private String nombreCorte;

    
    /**
     * Métodos GET y SET 
     */
    
    public int getIdCorte() {
        return idCorte;
    }

    public void setIdCorte(int idCorte) {
        this.idCorte = idCorte;
    }

    public String getNombreCorte() {
        return nombreCorte;
    }

    public void setNombreCorte(String nombreCorte) {
        this.nombreCorte = nombreCorte;
    }
    
    
}

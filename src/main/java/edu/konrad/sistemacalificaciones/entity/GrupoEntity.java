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
 * Clase encargada de crear la entidad de la tabla Grupo
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name="Grupo")
public class GrupoEntity implements Serializable{
    
    /**
     * Llave primaria de la entidad Grupo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idGrupo;

     /**
     * Columna que hace referencia al nombre del grupo
     */
    @Column(name = "nombre_grupo", nullable = false)
    private String nombreGrupo;    

    
   /**
    * Métodos GET y SET 
    */
    
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
    
    
}

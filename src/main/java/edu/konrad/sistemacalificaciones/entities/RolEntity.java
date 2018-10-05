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
 * Clase encargada de crear la entidad Rol
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name = "Rol")
public class RolEntity implements Serializable {

    /**
     * Llave primaria de la entidad Rol
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRol;

    /**
     * Columna que hace referencia al nombre del rol
     */
    @Column(name = "nombre_rol", nullable = false)
    private String nombreRol;

    /**
     * Métodos GET Y SET
     */
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

}

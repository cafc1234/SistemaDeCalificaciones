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
import javax.persistence.OneToOne;

/**
 * Clase encargada de crear la entidad de la tabla ProfesorEntity
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name="Profesor")
public class ProfesorEntity implements Serializable{
    
    /**
     * Llave primaria de la entidad ProfesorEntity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProfesor;
    
     /**
     * Columna que hace referencia al codigo de la cuenta y es una relación uno
     * a uno con la tabla cuenta tabla Rol
     */
    @OneToOne
    @JoinColumn(name = "codigo")
    private PersonaEntity codigo;
    
     /**
     * Columna que hace referencia al área de profundización
     */
    @Column(name = "area_profundizacion", nullable = false)
    private String areaProfundizacion;

    /**
     * Métodos GET y SET 
     */
    
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public PersonaEntity getCodigo() {
        return codigo;
    }

    public void setCodigo(PersonaEntity codigo) {
        this.codigo = codigo;
    }

    public String getAreaProfundizacion() {
        return areaProfundizacion;
    }

    public void setAreaProfundizacion(String areaProfundizacion) {
        this.areaProfundizacion = areaProfundizacion;
    }
    
    
}

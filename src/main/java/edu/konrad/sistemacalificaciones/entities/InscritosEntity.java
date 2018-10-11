/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase encargada de crear la entidad de la tabla inscritos donde se
 * relacionarán los estudiantes vinculados a los grupos
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name = "Inscritos")
public class InscritosEntity implements Serializable {

    /**
     * Llave primaria de la entidad Inscritos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idInscrito;
    
     /**
     * Columna que hace referencia al id del grupo y se relaciona con la
     * tabla Curso
     */
    @ManyToOne
    @JoinColumn(name = "idGrupo")
    private CursoEntity grupo;

    
     /**
     * Columna que hace referencia al código del estudiante y se relaciona con la tabla persona
     */
    @ManyToOne
    @JoinColumn(name = "codigo")
    private PersonaEntity estudiante;

    /**
     * Métodos GET y SET 
     */
    
    public int getIdInscrito() {
        return idInscrito;
    }

    public void setIdInscrito(int idInscrito) {
        this.idInscrito = idInscrito;
    }

    public CursoEntity getGrupo() {
        return grupo;
    }

    public void setGrupo(CursoEntity grupo) {
        this.grupo = grupo;
    }


    public PersonaEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(PersonaEntity estudiante) {
        this.estudiante = estudiante;
    }




}



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
 * Clase encargada de crear la entidad de la tabla Entity
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name="Curso")
public class CursoEntity  implements Serializable{
  
    /**
     * Llave primaria de la entidad Grupo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCurso;

     /**
     * Columna que hace referencia al nombre del curso
     */
    @Column(name = "nombre_curso", nullable = false)
    private String nombreCurso; 
    
     /**
     * Columna que hace referencia al tipo de documento y se relaciona con la
     * tabla TipoCurso
     */
    @ManyToOne
    @JoinColumn(name = "idTipo")
    private TipoCursoEntity tipo;
    
     /**
     * Columna que hace referencia al id del grupo y se relaciona con la
     * tabla Grupo
     */
    @ManyToOne
    @JoinColumn(name = "idGrupo")
    private GrupoEntity grupo;
    
     /**
     * Columna que hace referencia al codigo del profesor y se relaciona con la
     * tabla profesor
     */
    
    @ManyToOne
    @JoinColumn(name = "codigo")
    private ProfesorEntity profesor;
    
         /**
     * Columna que hace referencia al codigo del nivel y se relaciona con la
     * tabla tipo nivel
     */
    
    @ManyToOne
    @JoinColumn(name = "tipo_nivel")
    private TipoNivelEntity nivel;

   
    /**
     * Métodos GET Y SET 
     */
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public TipoCursoEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoCursoEntity tipo) {
        this.tipo = tipo;
    }

    public GrupoEntity getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoEntity grupo) {
        this.grupo = grupo;
    }

    public ProfesorEntity getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorEntity profesor) {
        this.profesor = profesor;
    }

    public TipoNivelEntity getNivel() {
        return nivel;
    }

    public void setNivel(TipoNivelEntity nivel) {
        this.nivel = nivel;
    }
    
    

    
    
    
   
    
    
    
}

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
 *Clase encargada de crear la entidad de la tabla notas
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name="Horarios")
public class HorariosEntity implements Serializable{
    
    /**
     * Llave primaria de la entidad horarios
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idHorario;
    
    
     /**
     * Columna que hace referencia al id del grupo e id del curso y se relaciona con la
     * tabla Horarios
     */
    @ManyToOne
    @JoinColumn(name = "idGrupo")
    private CursoEntity grupo;
    
     /**
     * Columna que hace referencia al codigo del profesor y se relaciona con la
     * tabla profesor
     */
   
    @ManyToOne
    @JoinColumn(name = "codigo")
    private ProfesorEntity profesor;
    
     /**
     * Columna que hace referencia al día de la semana
     */
    @Column(name = "dia_semana", nullable = false)
    private String diaSemana; 
    
     /**
     * Columna que hace referencia a la hora de inicio de clase
     */
    @Column(name = "hora_inicio", nullable = false)
    private String horaInicio; 
    
     /**
     * Columna que hace referencia a la hora de fin de clase
     */
    @Column(name = "hora_fin", nullable = false)
    private String horaFin; 

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public CursoEntity getGrupo() {
        return grupo;
    }

    public void setGrupo(CursoEntity grupo) {
        this.grupo = grupo;
    }

    public ProfesorEntity getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorEntity profesor) {
        this.profesor = profesor;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    
    /**
     * Métodos GET y SET 
     */
    
    
    
}

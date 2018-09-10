/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
}

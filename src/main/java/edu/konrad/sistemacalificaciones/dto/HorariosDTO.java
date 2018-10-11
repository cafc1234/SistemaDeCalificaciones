/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.HorariosEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Horarios
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class HorariosDTO {

    /**
     * Atributo que hace referencia al ID del Horario
     */
    private int id;

    /**
     * Atributo que hace referencia al id del curso y del grupo y se relaciona
     * con cursos
     */
    private CursoDTO grupo;

    /**
     * Atributo que hace referencia al profesor que le corresponde el horario
     */
    private ProfesorDTO profesor;

    /**
     * Atributo que hace referencia al día de la semana
     */
    private String diaSemana;

    /**
     * Atributo que hace referencia a la hora de inicio del horario
     *
     */
    private String horaInicio;

    /**
     * Atributo que hace referencia a la hora de fin del horario
     */
    private String horaFin;

    /**
     * Constructor vacio
     */
    public HorariosDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param horariosEntity
     */
    public HorariosDTO(HorariosEntity horariosEntity) {
        this.id = horariosEntity.getIdHorario();
        if (horariosEntity.getGrupo() != null) {
            this.grupo = new CursoDTO(horariosEntity.getGrupo());
        }
        if (horariosEntity.getProfesor() != null) {
            this.profesor = new ProfesorDTO(horariosEntity.getProfesor());
        }
        this.diaSemana = horariosEntity.getDiaSemana();
        this.horaInicio = horariosEntity.getHoraInicio();
        this.horaFin = horariosEntity.getHoraFin();

    }

    /**
     * Transformacion objeto - entidad
     *
     *
     * @return HorariosEntity
     */
    public HorariosEntity toEntity() {
        HorariosEntity horariosEntity = new HorariosEntity();
        horariosEntity.setIdHorario(this.id);
        if (this.grupo != null) {
            horariosEntity.setGrupo(this.grupo.toEntity());
        }
        if (this.profesor != null) {
            horariosEntity.setProfesor(this.profesor.toEntity());
        }
        horariosEntity.setDiaSemana(this.diaSemana);
        horariosEntity.setHoraInicio(this.horaInicio);
        horariosEntity.setHoraFin(this.horaFin);
        return horariosEntity;
    }

    /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaHorarios
     * @return
     */
    public static List<HorariosDTO> toHorariosList(List<HorariosEntity> listaHorarios) {
        List<HorariosDTO> listaHorariosDTO = new ArrayList<>();
        for (HorariosEntity entity : listaHorarios) {
            listaHorariosDTO.add(new HorariosDTO(entity));
        }
        return listaHorariosDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CursoDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(CursoDTO grupo) {
        this.grupo = grupo;
    }

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
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
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.HorariosEntity;
import edu.konrad.sistemacalificaciones.persistence.HorariosPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Horarios
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class HorariosLogic {
    /**
     * Inyeccion del persistence de Horarios
     */
    @Inject
    private HorariosPersistence horariosPersistence;

    /**
     * Obtener todos los objetos Horarios
     *
     * @return
     */
    public List<HorariosEntity> obtenerHorarios() {
        List<HorariosEntity> horarioss = horariosPersistence.findAll();
        return horarioss;
    }

    /**
     * Obtener Horarios por su id
     *
     * @param id
     * @return HorariosEntity
     */
    public HorariosEntity obtenerHorarios(int id) {
        HorariosEntity horarios = horariosPersistence.find(id);
        if (horarios == null) {
            throw new IllegalArgumentException("El horarios solicitado NO existe");
        }
        return horarios;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un Horarios
     *
     * @param horariosCrear
     * @return horarios creado
     */
    public HorariosEntity crearHorarios(HorariosEntity horariosCrear) {
        horariosPersistence.create(horariosCrear);
        return horariosCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * Horarios
     *
     * @param id
     * @param horariosActualizar
     * @return Horarios actualizado
     */
    public HorariosEntity actualizarHorarios(int id, HorariosEntity horariosActualizar) {
        HorariosEntity horariosUpdate = horariosPersistence.update(horariosActualizar);
        return horariosUpdate;
    }

    /**
     * Metodo para eliminar un objeto Horarios
     *
     * @param id
     */
    public void eliminarHorarios(int id) {
        horariosPersistence.remove(id);
    }    
}

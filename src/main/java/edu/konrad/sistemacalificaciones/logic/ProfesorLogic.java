/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.ProfesorEntity;
import edu.konrad.sistemacalificaciones.persistence.ProfesorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Profesor
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class ProfesorLogic {
    /**
     * Inyeccion del persistence de Profesor
     */
    @Inject
    private ProfesorPersistence profesorPersistence;

    /**
     * Obtener todos los objetos Profesor
     *
     * @return
     */
    public List<ProfesorEntity> obtenerProfesor() {
        List<ProfesorEntity> profesors = profesorPersistence.findAll();
        return profesors;
    }

    /**
     * Obtener Profesor por su id
     *
     * @param id
     * @return ProfesorEntity
     */
    public ProfesorEntity obtenerProfesor(int id) {
        ProfesorEntity profesor = profesorPersistence.find(id);
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor solicitado NO existe");
        }
        return profesor;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un Profesor
     *
     * @param profesorCrear
     * @return profesor creado
     */
    public ProfesorEntity crearProfesor(ProfesorEntity profesorCrear) {
        profesorPersistence.create(profesorCrear);
        return profesorCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * Profesor
     *
     * @param id
     * @param profesorActualizar
     * @return Profesor actualizado
     */
    public ProfesorEntity actualizarProfesor(int id, ProfesorEntity profesorActualizar) {
        ProfesorEntity profesorUpdate = profesorPersistence.update(profesorActualizar);
        return profesorUpdate;
    }

    /**
     * Metodo para eliminar un objeto Profesor
     *
     * @param id
     */
    public void eliminarProfesor(int id) {
        profesorPersistence.remove(id);
    }    
}

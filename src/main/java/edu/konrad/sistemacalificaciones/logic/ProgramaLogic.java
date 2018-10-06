/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.ProgramaEntity;
import edu.konrad.sistemacalificaciones.persistence.ProgramaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Programa
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class ProgramaLogic {

    /**
     * Inyeccion del persistence de Programa
     */
    @Inject
    private ProgramaPersistence programaPersistence;

    /**
     * Obtener todos los objetos Programa
     *
     * @return
     */
    public List<ProgramaEntity> obtenerPrograma() {
        List<ProgramaEntity> programas = programaPersistence.findAll();
        return programas;
    }

    /**
     * Obtener Programa por su id
     *
     * @param id
     * @return ProgramaEntity
     */
    public ProgramaEntity obtenerPrograma(int id) {
        ProgramaEntity programa = programaPersistence.find(id);
        if (programa == null) {
            throw new IllegalArgumentException("El programa solicitado NO existe");

        }
        return programa;
    }
     /**
     * Metodo que conecta la logica con la transaccion para crear un Programa
     *
     * @param programaCrear
     * @return programa creado
     */
    
    public ProgramaEntity crearPrograma(ProgramaEntity programaCrear){
    programaPersistence.create(programaCrear);
    return programaCrear;
    }
    
     /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * Programa
     *
     * @param id
     * @param programaActualizar
     * @return rol actualizado
     */
    public ProgramaEntity actualizarPrograma(int id, ProgramaEntity programaActualizar) {
        ProgramaEntity programaUpdate = programaPersistence.update(programaActualizar);
        return programaUpdate;
    }

     /**
     * Metodo para eliminar un objeto Programa
     *
     * @param id
     */
    public void eliminarPrograma(int id) {
        programaPersistence.remove(id);
    }


}

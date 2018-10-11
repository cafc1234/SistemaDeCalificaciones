/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.CursoEntity;
import edu.konrad.sistemacalificaciones.persistence.CursoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Curso
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class CursoLogic {
    /**
     * Inyeccion del persistence de Curso
     */
    @Inject
    private CursoPersistence cursoPersistence;

    /**
     * Obtener todos los objetos Curso
     *
     * @return
     */
    public List<CursoEntity> obtenerCurso() {
        List<CursoEntity> cursos = cursoPersistence.findAll();
        return cursos;
    }

    /**
     * Obtener Curso por su id
     *
     * @param id
     * @return CursoEntity
     */
    public CursoEntity obtenerCurso(int id) {
        CursoEntity curso = cursoPersistence.find(id);
        if (curso == null) {
            throw new IllegalArgumentException("El curso solicitado NO existe");
        }
        return curso;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un Curso
     *
     * @param cursoCrear
     * @return curso creado
     */
    public CursoEntity crearCurso(CursoEntity cursoCrear) {
        cursoPersistence.create(cursoCrear);
        return cursoCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * Curso
     *
     * @param id
     * @param cursoActualizar
     * @return Curso actualizado
     */
    public CursoEntity actualizarCurso(int id, CursoEntity cursoActualizar) {
        CursoEntity cursoUpdate = cursoPersistence.update(cursoActualizar);
        return cursoUpdate;
    }

    /**
     * Metodo para eliminar un objeto Curso
     *
     * @param id
     */
    public void eliminarCurso(int id) {
        cursoPersistence.remove(id);
    }    
}

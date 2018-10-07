/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.TipoCursoEntity;
import edu.konrad.sistemacalificaciones.persistence.TipoCursoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de TipoCurso
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless

public class TipoCursoLogic {

    /**
     * Inyeccion del persistence de TipoCurso
     */
    @Inject
    private TipoCursoPersistence tipoCursoPersistence;
    
     /**
     * Obtener todos los objetos Tipo Curso
     *
     * @return
     */

    public List<TipoCursoEntity> obtenerTipoCurso() {
        List<TipoCursoEntity> tipoCursos = tipoCursoPersistence.findAll();
        return tipoCursos;
    }
    
     /**
     * Obtener un tipoCurso por su id
     *
     * @param id
     * @return TipoCursoEntity
     */

    public TipoCursoEntity obtenerTipoCurso(int id) {
        TipoCursoEntity tipoCurso = tipoCursoPersistence.find(id);
        if (tipoCurso == null) {
            throw new IllegalArgumentException("El tipoCurso solicitado NO existe");
        }
        return tipoCurso;
    }

     /**
     * Metodo que conecta la logica con la transaccion para crear un tipo curso
     *
     * @param tipoCursoCrear
     * @return tipo curso creado
     */
    public TipoCursoEntity crearTipoCurso(TipoCursoEntity tipoCursoCrear) {
        tipoCursoPersistence.create(tipoCursoCrear);
        return tipoCursoCrear;
    }
    
     /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * tipoCurso
     *
     * @param id
     * @param tipoCursoActualizar
     * @return tipoCurso actualizado
     */
    public TipoCursoEntity actualizarTipoCurso(int id, TipoCursoEntity tipoCursoActualizar) {
        TipoCursoEntity tipoCursoUpdate = tipoCursoPersistence.update(tipoCursoActualizar);
        return tipoCursoUpdate;
    }

    /**
     * Metodo para eliminar un objeto TipoCurso
     *
     * @param id
     */
    public void eliminarTipoCurso(int id) {
        tipoCursoPersistence.remove(id);
    }

    
    
}

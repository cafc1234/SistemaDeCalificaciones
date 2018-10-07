/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.GrupoEntity;
import edu.konrad.sistemacalificaciones.persistence.GrupoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Grupo
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class GrupoLogic {
    /**
     * Inyeccion del persistence de Grupo
     */
    @Inject
    private GrupoPersistence grupoPersistence;

    /**
     * Obtener todos los objetos Grupo
     *
     * @return
     */
    public List<GrupoEntity> obtenerGrupo() {
        List<GrupoEntity> grupos = grupoPersistence.findAll();
        return grupos;
    }

    /**
     * Obtener Grupo por su id
     *
     * @param id
     * @return GrupoEntity
     */
    public GrupoEntity obtenerGrupo(int id) {
        GrupoEntity grupo = grupoPersistence.find(id);
        if (grupo == null) {
            throw new IllegalArgumentException("El grupo solicitado NO existe");
        }
        return grupo;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un Grupo
     *
     * @param grupoCrear
     * @return grupo creado
     */
    public GrupoEntity crearGrupo(GrupoEntity grupoCrear) {
        grupoPersistence.create(grupoCrear);
        return grupoCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * Grupo
     *
     * @param id
     * @param grupoActualizar
     * @return Grupo actualizado
     */
    public GrupoEntity actualizarGrupo(int id, GrupoEntity grupoActualizar) {
        GrupoEntity grupoUpdate = grupoPersistence.update(grupoActualizar);
        return grupoUpdate;
    }

    /**
     * Metodo para eliminar un objeto Grupo
     *
     * @param id
     */
    public void eliminarGrupo(int id) {
        grupoPersistence.remove(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.CorteEntity;
import edu.konrad.sistemacalificaciones.persistence.CortePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Corte
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class CorteLogic {

    /**
     * Inyeccion del persistence de Corte
     */
    @Inject
    private CortePersistence cortePersistence;

    /**
     * Obtener todos los objetos Corte
     *
     * @return
     */
    public List<CorteEntity> obtenerCorte() {
        List<CorteEntity> cortes = cortePersistence.findAll();
        return cortes;
    }

    /**
     * Obtener corte por su id
     *
     * @param id
     * @return CorteEntity
     */
    public CorteEntity obtenerCorte(int id) {
        CorteEntity corte = cortePersistence.find(id);
        if (corte == null) {
            throw new IllegalArgumentException("El corte solicitado NO existe");
        }
        return corte;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un Corte
     *
     * @param corteCrear
     * @return corte creado
     */
    public CorteEntity crearProducto(CorteEntity corteCrear) {
        cortePersistence.create(corteCrear);
        return corteCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * Corte
     *
     * @param id
     * @param corteActualizar
     * @return corte actualizado
     */
    public CorteEntity actualizarCorte(int id, CorteEntity corteActualizar) {
        CorteEntity corteUpdate = cortePersistence.update(corteActualizar);
        return corteUpdate;
    }

    /**
     * Metodo para eliminar un objeto Corte
     *
     * @param id
     */
    public void eliminarCorte(int id) {
        cortePersistence.remove(id);
    }

}

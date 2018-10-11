/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.InscritosEntity;
import edu.konrad.sistemacalificaciones.persistence.InscritosPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Inscritos
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class InscritosLogic {
    /**
     * Inyeccion del persistence de Inscritos
     */
    @Inject
    private InscritosPersistence inscritosPersistence;

    /**
     * Obtener todos los objetos Inscritos
     *
     * @return
     */
    public List<InscritosEntity> obtenerInscritos() {
        List<InscritosEntity> inscritoss = inscritosPersistence.findAll();
        return inscritoss;
    }

    /**
     * Obtener Inscritos por su id
     *
     * @param id
     * @return InscritosEntity
     */
    public InscritosEntity obtenerInscritos(int id) {
        InscritosEntity inscritos = inscritosPersistence.find(id);
        if (inscritos == null) {
            throw new IllegalArgumentException("El inscritos solicitado NO existe");
        }
        return inscritos;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un Inscritos
     *
     * @param inscritosCrear
     * @return inscritos creado
     */
    public InscritosEntity crearInscritos(InscritosEntity inscritosCrear) {
        inscritosPersistence.create(inscritosCrear);
        return inscritosCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * Inscritos
     *
     * @param id
     * @param inscritosActualizar
     * @return Inscritos actualizado
     */
    public InscritosEntity actualizarInscritos(int id, InscritosEntity inscritosActualizar) {
        InscritosEntity inscritosUpdate = inscritosPersistence.update(inscritosActualizar);
        return inscritosUpdate;
    }

    /**
     * Metodo para eliminar un objeto Inscritos
     *
     * @param id
     */
    public void eliminarInscritos(int id) {
        inscritosPersistence.remove(id);
    }    
}

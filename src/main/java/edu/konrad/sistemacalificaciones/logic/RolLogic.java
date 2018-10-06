/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.RolEntity;
import edu.konrad.sistemacalificaciones.persistence.RolPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Rol
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class RolLogic {

    /**
     * Inyeccion del persistence de Rol
     */
    @Inject
    private RolPersistence rolPersistence;

    /**
     * Obtener todos los objetos Rol
     *
     * @return
     */
    public List<RolEntity> obtenerRol() {
        List<RolEntity> roles = rolPersistence.findAll();
        return roles;
    }

    /**
     * Obtener rol por su id
     *
     * @param id
     * @return RolEntity
     */

    public RolEntity obtenerRol(int id) {
        RolEntity rol = rolPersistence.find(id);
        if (rol == null) {
            throw new IllegalArgumentException("El rol solicitado NO existe");
        }
        return rol;
    }
    
     /**
     * Metodo que conecta la logica con la transaccion para crear un Rol
     *
     * @param rolCrear
     * @return rol creado
     */
    public RolEntity crearRol(RolEntity rolCrear) {
        rolPersistence.create(rolCrear);
        return rolCrear;
    }
    
     /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * rol
     *
     * @param id
     * @param rolActualizar
     * @return rol actualizado
     */
    public RolEntity actualizarRol(int id, RolEntity rolActualizar) {
        RolEntity rolUpdate = rolPersistence.update(rolActualizar);
        return rolUpdate;
    }

    /**
     * Metodo para eliminar un objeto Rol
     *
     * @param id
     */
    public void eliminarRol(int id) {
        rolPersistence.remove(id);
    }


}

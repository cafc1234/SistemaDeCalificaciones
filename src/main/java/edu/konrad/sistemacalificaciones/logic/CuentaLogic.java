/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.CuentaEntity;
import edu.konrad.sistemacalificaciones.persistence.CuentaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de cuenta
 * 
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class CuentaLogic {
    
    /**
     * Persistence de cuenta
     */
    @Inject 
    private CuentaPersistence cuentaPersistence;
    
    /**
     * Obtener todos los objetos cuentas
     * @return cuentas
     */
    public List<CuentaEntity> obtenerCuenta(){
        List<CuentaEntity> cuentas = cuentaPersistence.findAll();
        return cuentas;
    }
    
     /**
     * Obtener cuenta por su id
     *
     * @param id
     * @return CuentaEntity
     */
    public CuentaEntity obtenerCuenta(Long id) {
        CuentaEntity cuenta = cuentaPersistence.find(id);
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta solicitada NO existe");
        }
        return cuenta;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear una cuenta
     *
     * @param cuentaCrear
     * @return cuenta creada
     */
    public CuentaEntity crearCuenta(CuentaEntity cuentaCrear) {
        cuentaPersistence.create(cuentaCrear);
        return cuentaCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar una
     * Cuenta
     *
     * @param id
     * @param cuentaActualizar
     * @return cuenta actualizado
     */
    public CuentaEntity actualizarCuenta(Long id, CuentaEntity cuentaActualizar) {
        CuentaEntity cuentaUpdate = cuentaPersistence.update(cuentaActualizar);
        return cuentaUpdate;
    }

    /**
     * Metodo para eliminar un objeto Cuenta
     *
     * @param id
     */
    public void eliminarCuenta(Long id) {
        cuentaPersistence.remove(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.NotasEntity;
import edu.konrad.sistemacalificaciones.persistence.NotasPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Notas
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class NotasLogic {
    /**
     * Inyeccion del persistence de Notas
     */
    @Inject
    private NotasPersistence notasPersistence;

    /**
     * Obtener todos los objetos Notas
     *
     * @return
     */
    public List<NotasEntity> obtenerNotas() {
        List<NotasEntity> notass = notasPersistence.findAll();
        return notass;
    }

    /**
     * Obtener Notas por su id
     *
     * @param id
     * @return NotasEntity
     */
    public NotasEntity obtenerNotas(int id) {
        NotasEntity notas = notasPersistence.find(id);
        if (notas == null) {
            throw new IllegalArgumentException("El notas solicitado NO existe");
        }
        return notas;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un Notas
     *
     * @param notasCrear
     * @return notas creado
     */
    public NotasEntity crearNotas(NotasEntity notasCrear) {
        notasPersistence.create(notasCrear);
        return notasCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * Notas
     *
     * @param id
     * @param notasActualizar
     * @return Notas actualizado
     */
    public NotasEntity actualizarNotas(int id, NotasEntity notasActualizar) {
        NotasEntity notasUpdate = notasPersistence.update(notasActualizar);
        return notasUpdate;
    }

    /**
     * Metodo para eliminar un objeto Notas
     *
     * @param id
     */
    public void eliminarNotas(int id) {
        notasPersistence.remove(id);
    }       
}

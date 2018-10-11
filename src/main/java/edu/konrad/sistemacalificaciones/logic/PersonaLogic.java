/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.logic;

import edu.konrad.sistemacalificaciones.entities.PersonaEntity;
import edu.konrad.sistemacalificaciones.persistence.PersonaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Persona
 * 
 * @author Evelyn Guzman y Camilo Fique.
 */
@Stateless
public class PersonaLogic {
   /**
     * Persistence de persona
     */
    @Inject 
    private PersonaPersistence personaPersistence;
    
    /**
     * Obtener todos los objetos personas
     * @return personas
     */
    public List<PersonaEntity> obtenerPersona(){
        List<PersonaEntity> personas = personaPersistence.findAll();
        return personas;
    }
    
     /**
     * Obtener persona por su id
     *
     * @param id
     * @return PersonaEntity
     */
    public PersonaEntity obtenerPersona(int id) {
        PersonaEntity persona = personaPersistence.find(id);
        if (persona == null) {
            throw new IllegalArgumentException("La persona solicitada NO existe");
        }
        return persona;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear una persona
     *
     * @param personaCrear
     * @return persona creada
     */
    public PersonaEntity crearPersona(PersonaEntity personaCrear) {
        personaPersistence.create(personaCrear);
        return personaCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar una
     * Persona
     *
     * @param id
     * @param personaActualizar
     * @return persona actualizado
     */
    public PersonaEntity actualizarPersona(Long id, PersonaEntity personaActualizar) {
        PersonaEntity personaUpdate = personaPersistence.update(personaActualizar);
        return personaUpdate;
    }

    /**
     * Metodo para eliminar un objeto Persona
     *
     * @param id
     */
    public void eliminarPersona(int id) {
        personaPersistence.remove(id);
    }    
}

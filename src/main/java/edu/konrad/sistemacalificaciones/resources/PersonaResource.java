/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.PersonaDTO;
import edu.konrad.sistemacalificaciones.entities.PersonaEntity;
import edu.konrad.sistemacalificaciones.logic.PersonaLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Recurso de Personas
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/personas")
public class PersonaResource {
 
    @EJB
    private PersonaLogic personaLogic;
    
    /**
     * Metodo que obtiene todos los datos de persona
     * @return Lista PersonaDTO
     */
    @GET
    public List<PersonaDTO> getPersonaList(){
        List <PersonaEntity> personas = personaLogic.obtenerPersona();
        return PersonaDTO.toPersonaList(personas);
    }
    
     /**
     * Obtener persona por su id
     * @param id
     * @return personaEntity
     */
    @GET
    @Path("{id: \\d+}")
    public PersonaDTO getPersona(@PathParam("id") int id){
        PersonaEntity persona = personaLogic.obtenerPersona(id);
        if (persona == null){
            throw new RuntimeException("La persona no existe");
        } 
        return new PersonaDTO(persona);
    }
    
    @POST
    public PersonaDTO createPersona(PersonaDTO personaDTO){
        return new PersonaDTO(personaLogic.crearPersona(personaDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un persona
     * @param id
     * @param personaDTO
     * @return personaDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public PersonaDTO updatePersona(@PathParam("id") int id, PersonaDTO personaDTO){
        PersonaEntity personaEntity = personaLogic.obtenerPersona(id);
        if(personaEntity == null){
            throw new RuntimeException("El persona no existe.");
        }
        return new PersonaDTO(personaLogic.actualizarPersona(id, personaDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deletePersona(@PathParam("id") int id){
        PersonaEntity personaEntity = personaLogic.obtenerPersona(id);
        if(personaEntity == null){
            throw new RuntimeException("El persona no existe.");
        }
        personaLogic.eliminarPersona(id);
    }    
    
}

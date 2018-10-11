/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.ProfesorDTO;
import edu.konrad.sistemacalificaciones.entities.ProfesorEntity;
import edu.konrad.sistemacalificaciones.logic.ProfesorLogic;
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
 * Recurso de Profesores
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/profesores")
public class ProfesorResource {
   @EJB
    private ProfesorLogic profesorLogic;
    
    /**
     * Metodo que obtiene todos los datos de Profesor
     * @return Lista ProfesorDTO
     */
    @GET
    public List<ProfesorDTO> getProfesorList(){
        List <ProfesorEntity> profesors = profesorLogic.obtenerProfesor();
        return ProfesorDTO.toProfesorList(profesors);
    }
    
     /**
     * Obtener Profesor por su id
     * @param id
     * @return profesorEntity
     */
    @GET
    @Path("{id: \\d+}")
    public ProfesorDTO getProfesor(@PathParam("id") int id){
        ProfesorEntity profesor = profesorLogic.obtenerProfesor(id);
        if (profesor == null){
            throw new RuntimeException("El profesor no existe");
        } 
        return new ProfesorDTO(profesor);
    }
    
    @POST
    public ProfesorDTO createProfesor(ProfesorDTO profesorDTO){
        return new ProfesorDTO(profesorLogic.crearProfesor(profesorDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un Profesor
     * @param id
     * @param profesorDTO
     * @return profesorDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public ProfesorDTO updateProfesor(@PathParam("id") int id, ProfesorDTO profesorDTO){
        ProfesorEntity profesorEntity = profesorLogic.obtenerProfesor(id);
        if(profesorEntity == null){
            throw new RuntimeException("El profesor no existe.");
        }
        return new ProfesorDTO(profesorLogic.actualizarProfesor(id, profesorDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProfesor(@PathParam("id") int id){
        ProfesorEntity profesorEntity = profesorLogic.obtenerProfesor(id);
        if(profesorEntity == null){
            throw new RuntimeException("El profesor no existe.");
        }
        profesorLogic.eliminarProfesor(id);
    }    
}

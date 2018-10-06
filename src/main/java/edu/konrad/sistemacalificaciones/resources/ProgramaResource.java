/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.ProgramaDTO;
import edu.konrad.sistemacalificaciones.entities.ProgramaEntity;
import edu.konrad.sistemacalificaciones.logic.ProgramaLogic;
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
 * Recurso de Programa
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/programas")
public class ProgramaResource {
 
    @EJB
    private ProgramaLogic programaLogic;
    
    /**
     * Metodo que obtiene todos los datos de programa
     * @return Lista ProgramaDTO
     */
    @GET
    public List<ProgramaDTO> getProgramaList(){
        List <ProgramaEntity> programas = programaLogic.obtenerPrograma();
        return ProgramaDTO.toProgramasList(programas);
    }
    
     /**
     * Obtener programa por su id
     * @param id
     * @return programaEntity
     */
    @GET
    @Path("{id: \\d+}")
    public ProgramaDTO getPrograma(@PathParam("id") int id){
        ProgramaEntity programa = programaLogic.obtenerPrograma(id);
        if (programa == null){
            throw new RuntimeException("El programa no existe");
        } 
        return new ProgramaDTO(programa);
    }
    
    @POST
    public ProgramaDTO createPrograma(ProgramaDTO programaDTO){
        return new ProgramaDTO(programaLogic.crearPrograma(programaDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un programa
     * @param id
     * @param programaDTO
     * @return programaDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public ProgramaDTO updatePrograma(@PathParam("id") int id, ProgramaDTO programaDTO){
        ProgramaEntity programaEntity = programaLogic.obtenerPrograma(id);
        if(programaEntity == null){
            throw new RuntimeException("El programa no existe.");
        }
        return new ProgramaDTO(programaLogic.actualizarPrograma(id, programaDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deletePrograma(@PathParam("id") int id){
        ProgramaEntity programaEntity = programaLogic.obtenerPrograma(id);
        if(programaEntity == null){
            throw new RuntimeException("El programa no existe.");
        }
        programaLogic.eliminarPrograma(id);
    }    
    
}

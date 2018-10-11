/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.NotasDTO;
import edu.konrad.sistemacalificaciones.entities.NotasEntity;
import edu.konrad.sistemacalificaciones.logic.NotasLogic;
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
 * Recurso de Notas
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/notas")
public class NotasResource {
   
    @EJB
    private NotasLogic notasLogic;
    
    /**
     * Metodo que obtiene todos los datos de Notas
     * @return Lista NotasDTO
     */
    @GET
    public List<NotasDTO> getNotasList(){
        List <NotasEntity> notas = notasLogic.obtenerNotas();
        return NotasDTO.toNotasList(notas);
    }
    
     /**
     * Obtener Notas por su id
     * @param id
     * @return notasEntity
     */
    @GET
    @Path("{id: \\d+}")
    public NotasDTO getNotas(@PathParam("id") int id){
        NotasEntity notas = notasLogic.obtenerNotas(id);
        if (notas == null){
            throw new RuntimeException("La nota no existe");
        } 
        return new NotasDTO(notas);
    }
    
    @POST
    public NotasDTO createNotas(NotasDTO notasDTO){
        return new NotasDTO(notasLogic.crearNotas(notasDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un Notas
     * @param id
     * @param notasDTO
     * @return notasDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public NotasDTO updateNotas(@PathParam("id") int id, NotasDTO notasDTO){
        NotasEntity notasEntity = notasLogic.obtenerNotas(id);
        if(notasEntity == null){
            throw new RuntimeException("La nota no existe.");
        }
        return new NotasDTO(notasLogic.actualizarNotas(id, notasDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteNotas(@PathParam("id") int id){
        NotasEntity notasEntity = notasLogic.obtenerNotas(id);
        if(notasEntity == null){
            throw new RuntimeException("La nota no existe.");
        }
        notasLogic.eliminarNotas(id);
    }        
}

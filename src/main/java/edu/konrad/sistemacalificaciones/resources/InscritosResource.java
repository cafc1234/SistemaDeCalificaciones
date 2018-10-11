/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.InscritosDTO;
import edu.konrad.sistemacalificaciones.entities.InscritosEntity;
import edu.konrad.sistemacalificaciones.logic.InscritosLogic;
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
 * Recurso de Inscritos
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscritos")
public class InscritosResource {
    @EJB
    private InscritosLogic inscritosLogic;
    
    /**
     * Metodo que obtiene todos los datos de Inscritos
     * @return Lista InscritosDTO
     */
    @GET
    public List<InscritosDTO> getInscritosList(){
        List <InscritosEntity> inscritos = inscritosLogic.obtenerInscritos();
        return InscritosDTO.toInscritosList(inscritos);
    }
    
     /**
     * Obtener Inscritos por su id
     * @param id
     * @return inscritosEntity
     */
    @GET
    @Path("{id: \\d+}")
    public InscritosDTO getInscritos(@PathParam("id") int id){
        InscritosEntity inscritos = inscritosLogic.obtenerInscritos(id);
        if (inscritos == null){
            throw new RuntimeException("El inscrito no existe");
        } 
        return new InscritosDTO(inscritos);
    }
    
    @POST
    public InscritosDTO createInscritos(InscritosDTO inscritosDTO){
        return new InscritosDTO(inscritosLogic.crearInscritos(inscritosDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un Inscritos
     * @param id
     * @param inscritosDTO
     * @return inscritosDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public InscritosDTO updateInscritos(@PathParam("id") int id, InscritosDTO inscritosDTO){
        InscritosEntity inscritosEntity = inscritosLogic.obtenerInscritos(id);
        if(inscritosEntity == null){
            throw new RuntimeException("El inscrito no existe.");
        }
        return new InscritosDTO(inscritosLogic.actualizarInscritos(id, inscritosDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteInscritos(@PathParam("id") int id){
        InscritosEntity inscritosEntity = inscritosLogic.obtenerInscritos(id);
        if(inscritosEntity == null){
            throw new RuntimeException("El inscrito no existe.");
        }
        inscritosLogic.eliminarInscritos(id);
    }   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.GrupoDTO;
import edu.konrad.sistemacalificaciones.entities.GrupoEntity;
import edu.konrad.sistemacalificaciones.logic.GrupoLogic;
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
 * Recurso de Grupo
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/grupos")
public class GrupoResource {
    
    @EJB
    private GrupoLogic grupoLogic;
    
    /**
     * Metodo que obtiene todos los datos de Grupo
     * @return Lista GrupoDTO
     */
    @GET
    public List<GrupoDTO> getGrupoList(){
        List <GrupoEntity> grupos = grupoLogic.obtenerGrupo();
        return GrupoDTO.toGrupoList(grupos);
    }
    
     /**
     * Obtener Grupo por su id
     * @param id
     * @return grupoEntity
     */
    @GET
    @Path("{id: \\d+}")
    public GrupoDTO getGrupo(@PathParam("id") int id){
        GrupoEntity grupo = grupoLogic.obtenerGrupo(id);
        if (grupo == null){
            throw new RuntimeException("El grupo no existe");
        } 
        return new GrupoDTO(grupo);
    }
    
    @POST
    public GrupoDTO createGrupo(GrupoDTO grupoDTO){
        return new GrupoDTO(grupoLogic.crearGrupo(grupoDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un Grupo
     * @param id
     * @param grupoDTO
     * @return grupoDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public GrupoDTO updateGrupo(@PathParam("id") int id, GrupoDTO grupoDTO){
        GrupoEntity grupoEntity = grupoLogic.obtenerGrupo(id);
        if(grupoEntity == null){
            throw new RuntimeException("El grupo no existe.");
        }
        return new GrupoDTO(grupoLogic.actualizarGrupo(id, grupoDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteGrupo(@PathParam("id") int id){
        GrupoEntity grupoEntity = grupoLogic.obtenerGrupo(id);
        if(grupoEntity == null){
            throw new RuntimeException("El grupo no existe.");
        }
        grupoLogic.eliminarGrupo(id);
    }    
}

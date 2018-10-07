/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.TipoCursoDTO;
import edu.konrad.sistemacalificaciones.entities.TipoCursoEntity;
import edu.konrad.sistemacalificaciones.logic.TipoCursoLogic;
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
 * Recurso de Tipo Curso
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tipoCursos")
public class TipoCursoResource {
    
     @EJB
    private TipoCursoLogic tipoCursoLogic;
    
    /**
     * Metodo que obtiene todos los datos de tipoCurso
     * @return Lista TipoCursoDTO
     */
    @GET
    public List<TipoCursoDTO> getTipoCursoList(){
        List <TipoCursoEntity> tipoCursos = tipoCursoLogic.obtenerTipoCurso();
        return TipoCursoDTO.toTipoCursoList(tipoCursos);
    }
    
     /**
     * Obtener tipoCurso por su id
     * @param id
     * @return tipoCursoEntity
     */
    @GET
    @Path("{id: \\d+}")
    public TipoCursoDTO getTipoCurso(@PathParam("id") int id){
        TipoCursoEntity tipoCurso = tipoCursoLogic.obtenerTipoCurso(id);
        if (tipoCurso == null){
            throw new RuntimeException("El tipoCurso no existe");
        } 
        return new TipoCursoDTO(tipoCurso);
    }
    

    
    
    @POST
    public TipoCursoDTO createTipoCurso(TipoCursoDTO tipoCursoDTO){
        return new TipoCursoDTO(tipoCursoLogic.crearTipoCurso(tipoCursoDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un tipoCurso
     * @param id
     * @param tipoCursoDTO
     * @return tipoCursoDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public TipoCursoDTO updateTipoCurso(@PathParam("id") int id, TipoCursoDTO tipoCursoDTO){
        TipoCursoEntity tipoCursoEntity = tipoCursoLogic.obtenerTipoCurso(id);
        if(tipoCursoEntity == null){
            throw new RuntimeException("El tipoCurso no existe.");
        }
        return new TipoCursoDTO(tipoCursoLogic.actualizarTipoCurso(id, tipoCursoDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTipoCurso(@PathParam("id") int id){
        TipoCursoEntity tipoCursoEntity = tipoCursoLogic.obtenerTipoCurso(id);
        if(tipoCursoEntity == null){
            throw new RuntimeException("El tipoCurso no existe.");
        }
        tipoCursoLogic.eliminarTipoCurso(id);
    }    
    
    
}

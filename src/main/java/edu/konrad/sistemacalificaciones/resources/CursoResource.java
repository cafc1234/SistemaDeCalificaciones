/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.CursoDTO;
import edu.konrad.sistemacalificaciones.entities.CursoEntity;
import edu.konrad.sistemacalificaciones.logic.CursoLogic;
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
 * Recurso de Curso
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cursos")
public class CursoResource {
    
    @EJB
    private CursoLogic cursoLogic;
    
    /**
     * Metodo que obtiene todos los datos de Curso
     * @return Lista CursoDTO
     */
    @GET
    public List<CursoDTO> getCursoList(){
        List <CursoEntity> cursos = cursoLogic.obtenerCurso();
        return CursoDTO.toCursosList(cursos);
    }
    
     /**
     * Obtener Curso por su id
     * @param id
     * @return cursoEntity
     */
    @GET
    @Path("{id: \\d+}")
    public CursoDTO getCurso(@PathParam("id") int id){
        CursoEntity curso = cursoLogic.obtenerCurso(id);
        if (curso == null){
            throw new RuntimeException("El curso no existe");
        } 
        return new CursoDTO(curso);
    }
    
    @POST
    public CursoDTO createCurso(CursoDTO cursoDTO){
        return new CursoDTO(cursoLogic.crearCurso(cursoDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un Curso
     * @param id
     * @param cursoDTO
     * @return cursoDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public CursoDTO updateCurso(@PathParam("id") int id, CursoDTO cursoDTO){
        CursoEntity cursoEntity = cursoLogic.obtenerCurso(id);
        if(cursoEntity == null){
            throw new RuntimeException("El curso no existe.");
        }
        return new CursoDTO(cursoLogic.actualizarCurso(id, cursoDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCurso(@PathParam("id") int id){
        CursoEntity cursoEntity = cursoLogic.obtenerCurso(id);
        if(cursoEntity == null){
            throw new RuntimeException("El curso no existe.");
        }
        cursoLogic.eliminarCurso(id);
    }    
}

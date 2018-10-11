/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.HorariosDTO;
import edu.konrad.sistemacalificaciones.entities.HorariosEntity;
import edu.konrad.sistemacalificaciones.logic.HorariosLogic;
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
 * Recurso de Horarios
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/horarios")
public class HorariosResource {
    
    @EJB
    private HorariosLogic horariosLogic;
    
    /**
     * Metodo que obtiene todos los datos de Horarios
     * @return Lista HorariosDTO
     */
    @GET
    public List<HorariosDTO> getHorariosList(){
        List <HorariosEntity> horarios = horariosLogic.obtenerHorarios();
        return HorariosDTO.toHorariosList(horarios);
    }
    
     /**
     * Obtener Horarios por su id
     * @param id
     * @return horariosEntity
     */
    @GET
    @Path("{id: \\d+}")
    public HorariosDTO getHorarios(@PathParam("id") int id){
        HorariosEntity horarios = horariosLogic.obtenerHorarios(id);
        if (horarios == null){
            throw new RuntimeException("El horario no existe");
        } 
        return new HorariosDTO(horarios);
    }
    
    @POST
    public HorariosDTO createHorarios(HorariosDTO horariosDTO){
        return new HorariosDTO(horariosLogic.crearHorarios(horariosDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un Horarios
     * @param id
     * @param horariosDTO
     * @return horariosDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public HorariosDTO updateHorarios(@PathParam("id") int id, HorariosDTO horariosDTO){
        HorariosEntity horariosEntity = horariosLogic.obtenerHorarios(id);
        if(horariosEntity == null){
            throw new RuntimeException("El horario no existe.");
        }
        return new HorariosDTO(horariosLogic.actualizarHorarios(id, horariosDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteHorarios(@PathParam("id") int id){
        HorariosEntity horariosEntity = horariosLogic.obtenerHorarios(id);
        if(horariosEntity == null){
            throw new RuntimeException("El horario no existe.");
        }
        horariosLogic.eliminarHorarios(id);
    }       
}

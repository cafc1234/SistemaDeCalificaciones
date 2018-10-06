/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.RolDTO;
import edu.konrad.sistemacalificaciones.entities.RolEntity;
import edu.konrad.sistemacalificaciones.logic.RolLogic;
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
 * Recurso de Rol
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/roles")
public class RolResource {
     @EJB
    private RolLogic rolLogic;
    
    /**
     * Metodo que obtiene todos los datos de rol
     * @return Lista RolDTO
     */
    @GET
    public List<RolDTO> getRolList(){
        List <RolEntity> roles = rolLogic.obtenerRol();
        return RolDTO.toRolList(roles);
    }
    
     /**
     * Obtener rol por su id
     * @param id
     * @return rolEntity
     */
    @GET
    @Path("{id: \\d+}")
    public RolDTO getRol(@PathParam("id") int id){
        RolEntity rol = rolLogic.obtenerRol(id);
        if (rol == null){
            throw new RuntimeException("El rol no existe");
        } 
        return new RolDTO(rol);
    }
    

    
    
    @POST
    public RolDTO createRol(RolDTO rolDTO){
        return new RolDTO(rolLogic.crearRol(rolDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un rol
     * @param id
     * @param rolDTO
     * @return rolDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public RolDTO updateRol(@PathParam("id") int id, RolDTO rolDTO){
        RolEntity rolEntity = rolLogic.obtenerRol(id);
        if(rolEntity == null){
            throw new RuntimeException("El rol no existe.");
        }
        return new RolDTO(rolLogic.actualizarRol(id, rolDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteRol(@PathParam("id") int id){
        RolEntity rolEntity = rolLogic.obtenerRol(id);
        if(rolEntity == null){
            throw new RuntimeException("El rol no existe.");
        }
        rolLogic.eliminarRol(id);
    }    
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.CorteDTO;
import edu.konrad.sistemacalificaciones.entities.CorteEntity;
import edu.konrad.sistemacalificaciones.logic.CorteLogic;
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
 * Recurso de Corte
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cortes")
public class CorteResource {
    
    @EJB
    private CorteLogic corteLogic;
    
    /**
     * Metodo que obtiene todos los datos de producto
     * @return Lista ProductoDTO
     */
    @GET
    public List<CorteDTO> getProductoList(){
        List <CorteEntity> cortes = corteLogic.obtenerCorte();
        return CorteDTO.toProductoList(cortes);
    }
    
     /**
     * Obtener producto por su id
     * @param id
     * @return ProductoEntity
     */
    @GET
    @Path("{id: \\d+}")
    public CorteDTO getCorte(@PathParam("id") int id){
        CorteEntity corte = corteLogic.obtenerCorte(id);
        if (corte == null){
            throw new RuntimeException("El corte no existe");
        } 
        return new CorteDTO(corte);
    }
    
    @POST
    public CorteDTO createCorte(CorteDTO corteDTO){
        return new CorteDTO(corteLogic.crearProducto(corteDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un corte
     * @param id
     * @param corteDTO
     * @return corteDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public CorteDTO updateCorte(@PathParam("id") int id, CorteDTO corteDTO){
        CorteEntity corteEntity = corteLogic.obtenerCorte(id);
        if(corteEntity == null){
            throw new RuntimeException("El corte no existe.");
        }
        return new CorteDTO(corteLogic.actualizarCorte(id, corteDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCorte(@PathParam("id") int id){
        CorteEntity corteEntity = corteLogic.obtenerCorte(id);
        if(corteEntity == null){
            throw new RuntimeException("El producto no existe.");
        }
        corteLogic.eliminarCorte(id);
    }    
}

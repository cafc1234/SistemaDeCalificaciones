/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.TipoNivelDTO;
import edu.konrad.sistemacalificaciones.entities.TipoNivelEntity;
import edu.konrad.sistemacalificaciones.logic.TipoNivelLogic;
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
 * Recurso de Tipo Nivel
 * @author Evelyn Guzman y Camilo Fique
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tiposNivel")

public class TipoNivelResource {
 
    
     @EJB
    private TipoNivelLogic tipoNivelLogic;
    
    /**
     * Metodo que obtiene todos los datos de tipoNivel
     * @return Lista TipoNivelDTO
     */
    @GET
    public List<TipoNivelDTO> getTipoNivelList(){
        List <TipoNivelEntity> tiposNivel = tipoNivelLogic.obtenerTipoNivel();
        return TipoNivelDTO.toTipoNivelList(tiposNivel);
    }
    
     /**
     * Obtener tipoNivel por su id
     * @param id
     * @return tipoNivelEntity
     */
    @GET
    @Path("{id: \\d+}")
    public TipoNivelDTO getTipoNivel(@PathParam("id") int id){
        TipoNivelEntity tipoNivel = tipoNivelLogic.obtenerTipoNivel(id);
        if (tipoNivel == null){
            throw new RuntimeException("El tipoNivel no existe");
        } 
        return new TipoNivelDTO(tipoNivel);
    }
    

    
    
    @POST
    public TipoNivelDTO createTipoNivel(TipoNivelDTO tipoNivelDTO){
        return new TipoNivelDTO(tipoNivelLogic.crearTipoNivel(tipoNivelDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un tipoNivel
     * @param id
     * @param tipoNivelDTO
     * @return tipoNivelDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public TipoNivelDTO updateTipoNivel(@PathParam("id") int id, TipoNivelDTO tipoNivelDTO){
        TipoNivelEntity tipoNivelEntity = tipoNivelLogic.obtenerTipoNivel(id);
        if(tipoNivelEntity == null){
            throw new RuntimeException("El tipoNivel no existe.");
        }
        return new TipoNivelDTO(tipoNivelLogic.actualizarTipoNivel(id, tipoNivelDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTipoNivel(@PathParam("id") int id){
        TipoNivelEntity tipoNivelEntity = tipoNivelLogic.obtenerTipoNivel(id);
        if(tipoNivelEntity == null){
            throw new RuntimeException("El tipoNivel no existe.");
        }
        tipoNivelLogic.eliminarTipoNivel(id);
    }    
    
}

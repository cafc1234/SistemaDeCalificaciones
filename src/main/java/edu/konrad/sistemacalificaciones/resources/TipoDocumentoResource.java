/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.TipoDocumentoDTO;
import edu.konrad.sistemacalificaciones.entities.TipoDocumentoEntity;
import edu.konrad.sistemacalificaciones.logic.TipoDocumentoLogic;
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
@Path("/tiposDocumento")

public class TipoDocumentoResource {
     @EJB
    private TipoDocumentoLogic tipoDocumentoLogic;
    
    /**
     * Metodo que obtiene todos los datos de tipoDocumento
     * @return Lista TipoDocumentoDTO
     */
    @GET
    public List<TipoDocumentoDTO> getTipoDocumentoList(){
        List <TipoDocumentoEntity> tiposNivel = tipoDocumentoLogic.obtenerTipoDocumento();
        return TipoDocumentoDTO.toTipoDocumentoList(tiposNivel);
    }
    
     /**
     * Obtener tipoDocumento por su id
     * @param id
     * @return tipoDocumentoEntity
     */
    @GET
    @Path("{id: \\d+}")
    public TipoDocumentoDTO getTipoDocumento(@PathParam("id") int id){
        TipoDocumentoEntity tipoDocumento = tipoDocumentoLogic.obtenerTipoDocumento(id);
        if (tipoDocumento == null){
            throw new RuntimeException("El tipoDocumento no existe");
        } 
        return new TipoDocumentoDTO(tipoDocumento);
    }
    

    
    
    @POST
    public TipoDocumentoDTO createTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO){
        return new TipoDocumentoDTO(tipoDocumentoLogic.crearTipoDocumento(tipoDocumentoDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un tipoDocumento
     * @param id
     * @param tipoDocumentoDTO
     * @return tipoDocumentoDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public TipoDocumentoDTO updateTipoDocumento(@PathParam("id") int id, TipoDocumentoDTO tipoDocumentoDTO){
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoLogic.obtenerTipoDocumento(id);
        if(tipoDocumentoEntity == null){
            throw new RuntimeException("El tipoDocumento no existe.");
        }
        return new TipoDocumentoDTO(tipoDocumentoLogic.actualizarTipoDocumento(id, tipoDocumentoDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTipoDocumento(@PathParam("id") int id){
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoLogic.obtenerTipoDocumento(id);
        if(tipoDocumentoEntity == null){
            throw new RuntimeException("El tipoDocumento no existe.");
        }
        tipoDocumentoLogic.eliminarTipoDocumento(id);
    }    
    
}

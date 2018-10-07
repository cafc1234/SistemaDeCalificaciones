/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import edu.konrad.sistemacalificaciones.dto.CuentaDTO;
import edu.konrad.sistemacalificaciones.entities.CuentaEntity;
import edu.konrad.sistemacalificaciones.logic.CuentaLogic;
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
 * Recurso de Cuenta
 * @author Evelyn Guzman y Camilo Fique
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cuentas")
public class CuentaResource {
    
    @EJB
    private CuentaLogic cuentaLogic;
    
    /**
     * Metodo que obtiene todos los datos de cuenta
     * @return Lista CuentaDTO
     */
    @GET
    public List<CuentaDTO> getCuentaList(){
        List <CuentaEntity> cuentas = cuentaLogic.obtenerCuenta();
        return CuentaDTO.toCuentaList(cuentas);
    }
    
     /**
     * Obtener cuenta por su id
     * @param id
     * @return cuentaEntity
     */
    @GET
    @Path("{id: \\d+}")
    public CuentaDTO getCuenta(@PathParam("id") Long id){
        CuentaEntity cuenta = cuentaLogic.obtenerCuenta(id);
        if (cuenta == null){
            throw new RuntimeException("La cuenta no existe");
        } 
        return new CuentaDTO(cuenta);
    }
    
    @POST
    public CuentaDTO createCuenta(CuentaDTO cuentaDTO){
        return new CuentaDTO(cuentaLogic.crearCuenta(cuentaDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un cuenta
     * @param id
     * @param cuentaDTO
     * @return cuentaDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public CuentaDTO updateCuenta(@PathParam("id") Long id, CuentaDTO cuentaDTO){
        CuentaEntity cuentaEntity = cuentaLogic.obtenerCuenta(id);
        if(cuentaEntity == null){
            throw new RuntimeException("La cuenta no existe.");
        }
        return new CuentaDTO(cuentaLogic.actualizarCuenta(id, cuentaDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCuenta(@PathParam("id") Long id){
        CuentaEntity cuentaEntity = cuentaLogic.obtenerCuenta(id);
        if(cuentaEntity == null){
            throw new RuntimeException("La cuenta no existe.");
        }
        cuentaLogic.eliminarCuenta(id);
    }    
}

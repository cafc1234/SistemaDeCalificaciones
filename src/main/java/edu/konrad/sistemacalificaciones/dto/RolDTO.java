/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.RolEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Rol
 *
 * @author Evelyn Guzman y Camilo Fique.
 */

public class RolDTO {
  
    /**
     * Atributo que hace referencia al id del objeto Rol
     */   
    
    private int id;
    
    /**
     * Atributo que hace referencia al nombre del objeto Rol
     */
    
    private String nombreRol;
    
     /**
     * Constructor por defecto
     */
    private RolDTO(){
    }
    
     /**
     * Transformación entidad - objeto
     *
     * @param RolEntity
     */
    
    public RolDTO(RolEntity rolEntity){
    this.id=rolEntity.getIdRol();
    this.nombreRol=rolEntity.getNombreRol();
    }
    
     /**
     * Transformacion objeto - entidad
     *
     * @return RolEntity
     */
    
    public RolEntity toEntity(){
    RolEntity rolEntity= new RolEntity();
    rolEntity.setIdRol(this.id);
    rolEntity.setNombreRol(this.nombreRol);
    return rolEntity;
    }
    
     /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaRoles
     * @return
     */
    
        public static List<RolDTO> toRolList(List<RolEntity> listaRoles) {
        List<RolDTO> listaRolesDTO = new ArrayList<>();
        for (RolEntity entity : listaRoles) {
            listaRolesDTO.add(new RolDTO(entity));
        }
        return listaRolesDTO;
    }


        
    /**
     * Metodos GET y SER
     */  
      
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }        
}

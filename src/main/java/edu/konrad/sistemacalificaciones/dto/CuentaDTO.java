/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.CuentaEntity;
import edu.konrad.sistemacalificaciones.entities.RolEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Cuenta
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class CuentaDTO {

    /**
     * Atributo que hace referencia al id del objeto cuenta
     */
    private Long id;

    /**
     * Atributo que hace referencia al código del objeto cuenta
     */
    private Long codigo;

    /**
     * Atributo que hace referencia al password del objeto cuenta
     */
    private String password;
    /**
     * Atributo que hace referencia al tipo rol del objeto cuenta
     */
    private RolDTO idRol;

    /**
     * Constructor vacio
     */
    public CuentaDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param cuentaEntity
     */
    public CuentaDTO(CuentaEntity cuentaEntity) {
        this.id = cuentaEntity.getIdCuenta();
        this.codigo = cuentaEntity.getCodigo();
        this.password = cuentaEntity.getPassword();
        if (cuentaEntity.getRol() != null) {
            RolEntity rolEntity = new RolEntity();
            rolEntity.setIdRol(cuentaEntity.getRol().getIdRol());
            rolEntity.setNombreRol(cuentaEntity.getRol().getNombreRol());
            this.idRol = new RolDTO(rolEntity);
        }
    }

    /**
     * Transformacion objeto - entidad
     *
     *
     * @return cuentaEntity
     */
    public CuentaEntity toEntity() {
        CuentaEntity cuentaEntity = new CuentaEntity();
        cuentaEntity.setCodigo(this.codigo);
        cuentaEntity.setIdCuenta(this.id);
        cuentaEntity.setPassword(this.password);
        if (this.idRol != null) {
            RolEntity rolEntity = new RolEntity();
            rolEntity.setIdRol(this.idRol.getId());
            rolEntity.setNombreRol(this.idRol.getNombreRol());
            cuentaEntity.setRol(rolEntity);
        }
        return cuentaEntity;
    }

     /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaCuentas
     * @return
     */
    
        public static List<CuentaDTO> toCuentaList(List<CuentaEntity> listaCuentas) {
        List<CuentaDTO> listaCuentasDTO = new ArrayList<>();
        for (CuentaEntity entity : listaCuentas) {
            listaCuentasDTO.add(new CuentaDTO(entity));
        }
        return listaCuentasDTO;
    }    
}

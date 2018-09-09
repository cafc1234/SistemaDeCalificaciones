/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase encargada de crear la entidad Cuenta
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name = "Cuenta")
public class CuentaEntity implements Serializable{

    /**
     * Llave primaria de la entidad Cuenta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCuenta;

     /**
     * Columna que hace referencia al código de inicio de cada cuenta
     */
    @Column(name = "codigo", nullable = false, unique=true)
    private Long codigo;
    
     /**
     * Columna que hace referencia al password de la cuenta
     */
    @Column(name = "password", nullable = false)
    private String password;

     /**
     * Columna que hace referencia al rol de la cuenta y se relaciona con la tabla Rol
     */
    @ManyToOne
    @JoinColumn(name= "idRol")
    private RolEntity Rol;  


    
    /**
     * Métodos GET y SET
     */
    
    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolEntity getRol() {
        return Rol;
    }

    public void setRol(RolEntity Rol) {
        this.Rol = Rol;
    }    
    
    
}

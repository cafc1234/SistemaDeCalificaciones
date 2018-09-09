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
import javax.persistence.OneToOne;

/**
 * Clase encargada de crear la entidad Persona
 *
 * @author Evelyn Guzman y Camilo Fique
 */
@Entity(name = "Persona")
public class PersonaEntity implements Serializable {

    /**
     * Llave primaria de la entidad persona
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPersona;

    /**
     * Columna que hace referencia al codigo de la cuenta y es una relación uno
     * a uno con la tabla cuenta tabla Rol
     */
    @OneToOne
    @JoinColumn(name = "codigo")
    private CuentaEntity codigo;
    
     /**
     * Columna que hace referencia al nombre de la persona
     */
    @Column(name = "nombre", nullable = false)
    private String nombre;
   
    /**
     * Columna que hace referencia al apellido de la persona
     */
    @Column(name = "apellido", nullable = false)
    private String apellido;
    
    /**
     * Columna que hace referencia al tipo de documento y se relaciona con la
     * tabla TipoDocumento
     */
    @ManyToOne
    @JoinColumn(name = "idTipo")
    private TipoDocumentoEntity tipo;
    
     /**
     * Columna que hace referencia al número de documento de la persona
     */
    @Column(name = "numero_documento", nullable = false, unique=true)
    private Long documento;
    
     /**
     * Columna que hace referencia al genero de persona
     */
    @Column(name = "genero", nullable = false)
    private String genero;
    
     /**
     * Columna que hace referencia al correo de persona
     */
    @Column(name = "correo", nullable = false, unique=true)
    private String correo;
    
    
    /**
     *  Columna que hace referencia al Id del programa, que se relaciona con el id del programa de la tabla
     * programa
     */
    
    @ManyToOne
    @JoinColumn(name = "idPrograma")
    private ProgramaEntity programa;    

    
    /**
     * Métodos GET y SET 
     */
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public CuentaEntity getCodigo() {
        return codigo;
    }

    public void setCodigo(CuentaEntity codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocumentoEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumentoEntity tipo) {
        this.tipo = tipo;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ProgramaEntity getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaEntity programa) {
        this.programa = programa;
    }
    
    
    
    
    
}

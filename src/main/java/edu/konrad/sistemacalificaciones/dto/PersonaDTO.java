/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.dto;

import edu.konrad.sistemacalificaciones.entities.PersonaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Persona
 *
 * @author Evelyn Guzman y Camilo Fique.
 */
public class PersonaDTO {

    /**
     * Atributo que hace referencia al id del objeto Persona
     */
    private int id;

    /**
     * Atributo que hace referencia al codigo del objeto Persona y se relaciona
     * con cuenta
     */
    private CuentaDTO codigo;

    /**
     * Atributo que hace referencia al nombre del objeto Persona
     */
    private String nombre;

    /**
     * Atributo que hace referencia al apellido del objeto Persona
     */
    private String apellido;

    /**
     * Atributo que hace referencia al tipo documento del objeto Persona y se
     * relaciona con tipo documento
     */
    private TipoDocumentoDTO tipoDocumento;

    /**
     * Atributo que hace referencia al documento del objeto Persona
     */
    private Long documento;

    /**
     * Atributo que hace referencia al genero del objeto Persona
     */
    private String genero;

    /**
     * Atributo que hace referencia al correo del objeto Persona
     */
    private String correo;

    /**
     * Atributo que hace referencia al programa del objeto Persona
     */
    private ProgramaDTO programa;

    /**
     * Constructor vacio
     */
    public PersonaDTO() {
    }

    /**
     * Transformacion entidad - objeto
     *
     * @param personaEntity
     */
    public PersonaDTO(PersonaEntity personaEntity) {
        this.id = personaEntity.getIdPersona();
        if (personaEntity.getCodigo() != null) {
            this.codigo = new CuentaDTO(personaEntity.getCodigo());
        }
        this.nombre = personaEntity.getNombre();
        this.apellido = personaEntity.getApellido();
        if (personaEntity.getTipo() != null) {
            this.tipoDocumento = new TipoDocumentoDTO(personaEntity.getTipo());
        }
        this.documento = personaEntity.getDocumento();
        this.genero = personaEntity.getGenero();
        this.correo = personaEntity.getCorreo();
        if (personaEntity.getPrograma() != null) {
            this.programa = new ProgramaDTO(personaEntity.getPrograma());
        }
    }

    /**
     * Transformacion objeto - entidad
     *
     *
     * @return PersonaEntity
     */
    public PersonaEntity toEntity() {
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setIdPersona(this.id);
        if (this.codigo != null) {
            personaEntity.setCodigo(this.codigo.toEntity());
        }
        personaEntity.setNombre(this.nombre);
        personaEntity.setApellido(this.apellido);
        if (this.tipoDocumento != null) {
            personaEntity.setTipo(this.tipoDocumento.toEntity());
        }
        personaEntity.setDocumento(this.documento);
        personaEntity.setGenero(this.genero);
        personaEntity.setCorreo(this.correo);
        if (this.programa != null) {
            personaEntity.setPrograma(this.programa.toEntity());
        }
        return personaEntity;

    }

    /**
     * Conversión masiva de objeto a entidad
     *
     * @param listaPersonas
     * @return
     */
    public static List<PersonaDTO> toPersonaList(List<PersonaEntity> listaPersonas) {
        List<PersonaDTO> listaPersonasDTO = new ArrayList<>();
        for (PersonaEntity entity : listaPersonas) {
            listaPersonasDTO.add(new PersonaDTO(entity));
        }
        return listaPersonasDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CuentaDTO getCodigo() {
        return codigo;
    }

    public void setCodigo(CuentaDTO codigo) {
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

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public ProgramaDTO getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaDTO programa) {
        this.programa = programa;
    }

}

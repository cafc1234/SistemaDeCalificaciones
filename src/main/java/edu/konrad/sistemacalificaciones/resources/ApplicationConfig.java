/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.sistemacalificaciones.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/**
 * Representa el registro de las clases que se personalizan como servicios REST
 * @author Evelyn Guzman y Camilo Fique.
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;      
    }
    
    // Se agregan los recursos correspondientes para la ejecución de los servicios REST 
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(edu.konrad.sistemacalificaciones.resources.CorteResource.class);
        resources.add(edu.konrad.sistemacalificaciones.resources.CuentaResource.class);
        resources.add(edu.konrad.sistemacalificaciones.resources.GrupoResource.class);
        resources.add(edu.konrad.sistemacalificaciones.resources.ProgramaResource.class);
        resources.add(edu.konrad.sistemacalificaciones.resources.RolResource.class);
        resources.add(edu.konrad.sistemacalificaciones.resources.TipoCursoResource.class);
        resources.add(edu.konrad.sistemacalificaciones.resources.TipoDocumentoResource.class);
        resources.add(edu.konrad.sistemacalificaciones.resources.TipoNivelResource.class);


    }    
}

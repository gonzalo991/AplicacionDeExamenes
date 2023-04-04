package com.sistema.examenes.entidades;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Anotation entity, designa que esto es una entiddad
@Entity
//Table desiga cual será la tabla correspondiente a esta clase
@Table(name="roles")
public class Rol {

    //Atributos de la clase Rol
    @Id
    private Long rolId;
    
    private String nombre;
    
    //Un rol puede pertenecer a muchos usuarios
    //Con cascade si modificamos el rol tambien le afectará a todos los usuarios
    //que contengan ese rol
    //Con el fetchtype lazy, al hacer una busqueda si yo quiero obtener estos datos debo indicarlo
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    
    //Constructor Vacío

    public Rol() {
    }
    
    
    //Constructor de la clase con atributos

    public Rol(Long rolId, String nombre) {
        this.rolId = rolId;
        this.nombre = nombre;
    }
    
    
    //Getters and Setters
    

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    @Override
    public String toString() {
        return "Rol{" + "rolId=" + rolId + ", nombre=" + nombre + ", usuarioRoles=" + usuarioRoles + '}';
    }
    
    
}

package com.sistema.examenes.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UsuarioRol {
    
    //Atributos de la clase Usuario Rol
    @Id
    //Generated value junto con la estrategia Generatiotype
    //indica que el id de la clase se geneerará automáticamente
    //dandole una clave primaria a la clase
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;
    
    
    //Muchos roles le pueden pertenecer al usuario
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    
    //Muchos usuario van a poder pertenecer a un único rol
    @ManyToOne
    private Rol rol;

    
    //Constructor vacío
    public UsuarioRol() {
    }

    //Constructor de la clase que recibe los atributos
    public UsuarioRol(Long usuarioRolId, Usuario usuario, Rol rol) {
        this.usuarioRolId = usuarioRolId;
        this.usuario = usuario;
        this.rol = rol;
    }

    
    //Getters and Setters
    public Long getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

   
    //Método toString

    @Override
    public String toString() {
        return "UsuarioRol{" + "usuarioRolId=" + usuarioRolId + ", usuario=" + usuario + ", rol=" + rol + '}';
    }
    
    
}

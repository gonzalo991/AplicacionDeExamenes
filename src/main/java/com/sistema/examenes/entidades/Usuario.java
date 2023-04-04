package com.sistema.examenes.entidades;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private boolean enable = true;

    private String perfil;

    //One refiere a usuario, quiere decir que un usuario puede tener muchos roles
    //to Many quiere decir que un usuario puede tener muchos roles
    ///Casacade de tipo All, cualquier operacion que afecte a usuario afectara a sus entidades
    //relacionadas directamente, si elimino un usuario de esta tabla tambien se eliminará de las otras tablas
    ///Fetch type Eager indica que los datos que estas pidiendo te serán mostrados de forma rápida, a diferencia de
    ///Lazy que solo te mostrará los resultados si tu lo indicas
    ///Mapped by indica la entidad propietaria de la relacion, en este caso indica que el usuario es el propietario de la relacion
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    
    //Constructor vacío
    public Usuario() {

    }

    
    //Constructor con atributos
    public Usuario(Long id, String username, String password, String nombre, String apellido,
            String email, String telefono, boolean enable, String perfil) {
        super();
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.enable = enable;
        this.perfil = perfil;
    }

    
    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    
    //Método toString
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", enable=" + enable + ", perfil=" + perfil + '}';
    }

}

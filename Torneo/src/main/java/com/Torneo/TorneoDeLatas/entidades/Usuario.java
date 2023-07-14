
package com.Torneo.TorneoDeLatas.entidades;


import com.Torneo.TorneoDeLatas.Rol;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table
public class Usuario  {
    
@Id  
private String email;
@Column(name="Dni")
private Integer dni; 
@Column(name="Nombre")
private String nombre;
@Column(name="Apellido")
private String apellido;
private double ecopuntos;
private String password;
@ManyToMany
private Collection <Rol>roles; 
 @Temporal(TemporalType.DATE)
 private Date alta;

    public Usuario() {
    }

    public Usuario(String email, Integer dni, String nombre, String apellido, double ecopuntos, String password, Collection<Rol> roles, Date alta) {
        this.email = email;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ecopuntos = ecopuntos;
        this.password = password;
        this.roles = roles;
        this.alta = alta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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

    public double getEcopuntos() {
        return ecopuntos;
    }

    public void setEcopuntos(double ecopuntos) {
        this.ecopuntos = ecopuntos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

   
  

    
 
 
}

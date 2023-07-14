
package com.Torneo.TorneoDeLatas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {
  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    private String nombre;

    public Rol() {
    }

    public Rol(long Id, String nombre) {
        this.Id = Id;
        this.nombre = nombre;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}

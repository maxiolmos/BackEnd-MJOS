package com.portfolio.mjos.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Habilidades {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private int id;
            
    @NotNull
    private String grupo;
            
    @NotNull
    private String nombre;
            
    @NotNull
    private String categoria;
    
    @NotNull
    private String nivel;
    
    private String img;
    
    //Constructores

    public Habilidades() {
    }

    public Habilidades(String grupo, String nombre, String categoria, String nivel, String img) {
        this.grupo = grupo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.nivel = nivel;
        this.img = img;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
    

    
    
 


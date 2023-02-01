package com.portfolio.mjos.DTO;

import jakarta.validation.constraints.NotBlank;

public class dtoHabilidades {
    
    @NotBlank
    private String grupo;
            
    @NotBlank
    private String nombre;
            
    @NotBlank
    private String categoria;
    
    @NotBlank
    private String nivel;
    
    private String img;
    
    
    //Constructores

    public dtoHabilidades() {
    }

    public dtoHabilidades(String grupo, String nombre, String categoria, String nivel, String img) {
        this.grupo = grupo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.nivel = nivel;
        this.img = img;
    }
    
    
    //Getters y Setters

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

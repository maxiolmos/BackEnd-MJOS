package com.portfolio.mjos.DTO;

import jakarta.validation.constraints.NotBlank;


public class dtoPersona {
    
    @NotBlank
    private String nombreCompleto;
    
    @NotBlank
    private String profesion1;
    
    @NotBlank
    private String profesion2;
    
    @NotBlank
    private String lugarResidencia;
 
    private String img;
    
    //Constructores

    public dtoPersona() {
    }

    public dtoPersona(String nombreCompleto, String profesion1, String profesion2, String lugarResidencia, String img) {
        this.nombreCompleto = nombreCompleto;
        this.profesion1 = profesion1;
        this.profesion2 = profesion2;
        this.lugarResidencia = lugarResidencia;
        this.img = img;
    }
    
    //Getters y Setters

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getProfesion1() {
        return profesion1;
    }

    public void setProfesion1(String profesion1) {
        this.profesion1 = profesion1;
    }

    public String getProfesion2() {
        return profesion2;
    }

    public void setProfesion2(String profesion2) {
        this.profesion2 = profesion2;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
    
}

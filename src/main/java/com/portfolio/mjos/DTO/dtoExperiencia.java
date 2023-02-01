package com.portfolio.mjos.DTO;

import jakarta.validation.constraints.NotBlank;

public class dtoExperiencia {

    @NotBlank
    private String experiencia;
    
    @NotBlank
    private String empresa;
    
    @NotBlank
    private String tareas;
    
    @NotBlank 
    private String periodo;
    
    private String img;
    

    //Constructores
    public dtoExperiencia() {
    }

    public dtoExperiencia(String experiencia, String empresa, String tareas, String periodo, String img) {
        this.experiencia = experiencia;
        this.empresa = empresa;
        this.tareas = tareas;
        this.periodo = periodo;
        this.img = img;
    }
    
    
    
    //Getters y Setters

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
}

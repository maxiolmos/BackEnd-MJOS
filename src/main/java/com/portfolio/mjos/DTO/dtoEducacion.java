package com.portfolio.mjos.DTO;

import jakarta.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;
    @NotBlank
    private String promedio;
    @NotBlank
    private String periodo;
    
    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String titulo, String institucion, String promedio, String periodo) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.promedio = promedio;
        this.periodo = periodo;
    }
    
    //Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    

    
}

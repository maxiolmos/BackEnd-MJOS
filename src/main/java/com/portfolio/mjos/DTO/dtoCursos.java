package com.portfolio.mjos.DTO;

import jakarta.validation.constraints.NotBlank;


public class dtoCursos {
    
    @NotBlank
    private String curso;
    
    @NotBlank
    private String institucionCurso;
    
    @NotBlank
    private String fechaFinalizacion;
    
    @NotBlank
    private String estado;
    
    private String img;
    
    //Constructores

    public dtoCursos() {
    }

    public dtoCursos(String curso, String institucionCurso, String fechaFinalizacion, String estado, String img) {
        this.curso = curso;
        this.institucionCurso = institucionCurso;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estado = estado;
        this.img = img;
    }
    
    //Getters y Setters

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstitucionCurso() {
        return institucionCurso;
    }

    public void setInstitucionCurso(String institucionCurso) {
        this.institucionCurso = institucionCurso;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}

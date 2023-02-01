package com.portfolio.mjos.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cursos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String curso;
    
    @NotNull 
    private String institucionCurso;
    
    @NotNull
    private String fechaFinalizacion;
    
    @NotNull
    private String estado;
    
    private String img;
    
    
    //Constructores

    public Cursos() {
    }

    public Cursos(String curso, String institucionCurso, String fechaFinalizacion, String estado, String img) {
        this.curso = curso;
        this.institucionCurso = institucionCurso;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estado = estado;
        this.img = img;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

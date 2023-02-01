package com.portfolio.mjos.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String experiencia;
    
    @NotNull
    private String empresa;
    
    @NotNull
    private String tareas;
    
    @NotNull 
    private String periodo;
    
    private String img;

    //Constructores
    
    public Experiencia() {
    }

    public Experiencia(String experiencia, String empresa, String tareas, String periodo, String img) {
        this.experiencia = experiencia;
        this.empresa = empresa;
        this.tareas = tareas;
        this.periodo = periodo;
        this.img = img;
    }

    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

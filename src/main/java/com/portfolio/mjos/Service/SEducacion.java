package com.portfolio.mjos.Service;

import com.portfolio.mjos.Entity.Educacion;
import com.portfolio.mjos.Repository.REducacion;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion rEducacion;
    
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
        
    public Optional<Educacion> getByTitulo(String titulo){
        return rEducacion.findByTitulo(titulo);
    }
        
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }
    
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return rEducacion.existsByTitulo(titulo);
    }
        
    }
    


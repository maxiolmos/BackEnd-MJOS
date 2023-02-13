package com.portfolio.mjos.Service;

import com.portfolio.mjos.Entity.Persona;
import com.portfolio.mjos.Repository.RPersona;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class SPersona {
    @Autowired 
    RPersona rPersona;
    
    public List<Persona> list(){
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return rPersona.findById(id);
    }
    
    public Optional<Persona> getByNombreCompleto(String nombreCompleto){
        return rPersona.findByNombreCompleto(nombreCompleto);
    }
    
    public void save(Persona persona){
        rPersona.save(persona);
    }
    
    public void delete(int id){
        rPersona.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
    
    public boolean existsByNombreCompleto(String nombreCompleto){
        return rPersona.existsByNombreCompleto(nombreCompleto);
    }
    
    
    
    
}


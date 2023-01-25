package com.portfolio.mjos.Service;

import com.portfolio.mjos.Entity.Persona;
import com.portfolio.mjos.Repository.IPersonaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class ImpPersonaService{
    @Autowired 
    IPersonaRepository iPersonaRepository;
    
    public List<Persona> list(){
        return iPersonaRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return iPersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombreCompleto(String nombreCompleto){
        return iPersonaRepository.findByNombreCompleto(nombreCompleto);
    }
    
    public void save(Persona persona){
        iPersonaRepository.save(persona);
    }
    
    public void delete(int id){
        iPersonaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iPersonaRepository.existsById(id);
    }
    
    public boolean existsByNombreCompleto(String nombreCompleto){
        return iPersonaRepository.existsByNombreCompleto(nombreCompleto);
    }
    
    
    
    
}

package com.portfolio.mjos.Service;

import com.portfolio.mjos.Entity.Experiencia;
import com.portfolio.mjos.Repository.RExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByExperiencia(String experiencia){
        return rExperiencia.findByExperiencia(experiencia);
    }
    
    public void save(Experiencia experiencia){
        rExperiencia.save(experiencia);
    }
    
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    
    public boolean existsByExperiencia(String experiencia){
        return rExperiencia.existsByExperiencia(experiencia);
    }
    
    
}

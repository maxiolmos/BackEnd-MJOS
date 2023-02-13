package com.portfolio.mjos.Repository;

import com.portfolio.mjos.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository<Persona, Integer>{
    public Optional<Persona> findByNombreCompleto(String nombreCompleto);
    public boolean existsByNombreCompleto (String nombreCompleto);
    
}

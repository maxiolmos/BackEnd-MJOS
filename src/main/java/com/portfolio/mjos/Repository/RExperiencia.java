package com.portfolio.mjos.Repository;

import com.portfolio.mjos.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByExperiencia (String experiencia);
    public boolean existsByExperiencia(String experiencia);
}

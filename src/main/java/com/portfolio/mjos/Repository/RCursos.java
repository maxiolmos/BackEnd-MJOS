package com.portfolio.mjos.Repository;

import com.portfolio.mjos.Entity.Cursos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCursos extends JpaRepository <Cursos, Integer> {
    Optional<Cursos> findByCurso(String curso);
    public boolean existsByCurso(String curso);
    
}

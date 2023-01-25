package com.portfolio.mjos.Security.Repository;

import com.portfolio.mjos.Security.Entity.Rol;
import com.portfolio.mjos.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepositoryImplementation<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

package com.portfolio.mjos.Controller;

import com.portfolio.mjos.DTO.dtoPersona;
import com.portfolio.mjos.Entity.Persona;
import com.portfolio.mjos.Security.Controller.Mensaje;
import com.portfolio.mjos.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://frontend-mjos2023.web.app","http://localhost:4200"})
public class CPersona {
    @Autowired
    SPersona sPersona;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = sPersona.getOne(id).get();
        
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    /*
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sPersona.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada correctamente"), HttpStatus.OK);
    }
    */
    
    
    /*
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombreCompleto())){
            return new ResponseEntity(new Mensaje("El nombre completo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
    
        if(sPersona.existsByNombreCompleto(dtopersona.getNombreCompleto())){
            return new ResponseEntity(new Mensaje("El nombre completo ya existe"), HttpStatus.BAD_REQUEST);
        }
    
        if(StringUtils.isBlank(dtopersona.getProfesion1())){
            return new ResponseEntity(new Mensaje("La primera profesión es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopersona.getProfesion2())){
            return new ResponseEntity(new Mensaje("La segunda profesión es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopersona.getLugarResidencia())){
            return new ResponseEntity(new Mensaje("El lugar de residencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(
                dtopersona.getNombreCompleto(), dtopersona.getProfesion1(), dtopersona.getProfesion2(), dtopersona.getLugarResidencia(), dtopersona.getImg()
        );
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona añadida correctamente"), HttpStatus.OK);
    }
    */
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(StringUtils.isBlank(dtopersona.getNombreCompleto())){
            return new ResponseEntity(new Mensaje("El nombre completo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(sPersona.existsByNombreCompleto(dtopersona.getNombreCompleto()) && sPersona.getByNombreCompleto(dtopersona.getNombreCompleto()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("El nombre completo ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopersona.getProfesion1())){
            return new ResponseEntity(new Mensaje("La primera profesión es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopersona.getProfesion2())){
            return new ResponseEntity(new Mensaje("La segunda profesión es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopersona.getLugarResidencia())){
            return new ResponseEntity(new Mensaje("El lugar de residencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
       
        Persona persona = sPersona.getOne(id).get();
        
        persona.setNombreCompleto(dtopersona.getNombreCompleto());
        persona.setProfesion1(dtopersona.getProfesion1());
        persona.setProfesion2(dtopersona.getProfesion2());
        persona.setLugarResidencia(dtopersona.getLugarResidencia());
        
        sPersona.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada correctamente"), HttpStatus.OK);
    }
}

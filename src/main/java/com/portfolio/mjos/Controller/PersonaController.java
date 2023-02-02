package com.portfolio.mjos.Controller;

import com.portfolio.mjos.DTO.dtoPersona;
import com.portfolio.mjos.Entity.Persona;
import com.portfolio.mjos.Security.Controller.Mensaje;
import com.portfolio.mjos.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://frontend-30555.web.app","http://localhost:4200"})

public class PersonaController {
   @Autowired
    ImpPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    */
    
    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombreCompleto())){
            return new ResponseEntity(new Mensaje("El nombre completo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(personaService.existsByNombreCompleto(dtopersona.getNombreCompleto())){
            return new ResponseEntity(new Mensaje("Ese nombre completo ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(
                dtopersona.getNombreCompleto(), dtopersona.getProfesion1(), dtopersona.getProfesion2(), dtopersona.getLugarResidencia(), dtopersona.getImg()
        );
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    }
    */
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombreCompleto(dtopersona.getNombreCompleto()) && personaService.getByNombreCompleto(dtopersona.getNombreCompleto()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombreCompleto())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
       
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombreCompleto(dtopersona.getNombreCompleto());
        persona.setProfesion1(dtopersona.getProfesion1());
        persona.setProfesion2(dtopersona.getProfesion2());
        persona.setLugarResidencia(dtopersona.getLugarResidencia());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    
}

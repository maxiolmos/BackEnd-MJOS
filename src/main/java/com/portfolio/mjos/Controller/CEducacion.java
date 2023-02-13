package com.portfolio.mjos.Controller;

import com.portfolio.mjos.DTO.dtoEducacion;
import com.portfolio.mjos.Entity.Educacion;
import com.portfolio.mjos.Security.Controller.Mensaje;
import com.portfolio.mjos.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://frontend-mjos2023.web.app","http://localhost:4200"})
public class CEducacion {

    @Autowired
    SEducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getTitulo())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByTitulo(dtoeducacion.getTitulo())){
            return new ResponseEntity(new Mensaje("El titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getInstitucion())){
            return new ResponseEntity(new Mensaje("La institución es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getPromedio())){
            return new ResponseEntity(new Mensaje("El promedio es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getPeriodo())){
            return new ResponseEntity(new Mensaje("El período es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        
        Educacion educacion = new Educacion(
                dtoeducacion.getTitulo(), dtoeducacion.getInstitucion(), dtoeducacion.getPromedio(), dtoeducacion.getPeriodo(), dtoeducacion.getImg()
        );
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion añadida correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getTitulo())){
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(sEducacion.existsByTitulo(dtoeducacion.getTitulo()) && sEducacion.getByTitulo(dtoeducacion.getTitulo()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("El titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getInstitucion())){
            return new ResponseEntity(new Mensaje("La institución es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getPromedio())){
            return new ResponseEntity(new Mensaje("El promedio es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getPeriodo())){
            return new ResponseEntity(new Mensaje("El período es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setTitulo(dtoeducacion.getTitulo());
        educacion.setInstitucion(dtoeducacion.getInstitucion());
        educacion.setPromedio(dtoeducacion.getPromedio());
        educacion.setPeriodo(dtoeducacion.getPeriodo());
        educacion.setImg(dtoeducacion.getImg());
        
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada correctamente"), HttpStatus.OK);
    }
}
  
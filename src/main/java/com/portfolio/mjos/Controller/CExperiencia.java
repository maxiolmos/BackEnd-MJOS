package com.portfolio.mjos.Controller;

import com.portfolio.mjos.DTO.dtoExperiencia;
import com.portfolio.mjos.Entity.Experiencia;
import com.portfolio.mjos.Security.Controller.Mensaje;
import com.portfolio.mjos.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"https://mgbfrontend.web.app","http://localhost:4200"})
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexperiencia){
        if(StringUtils.isBlank(dtoexperiencia.getExperiencia()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sExperiencia.existsByExperiencia(dtoexperiencia.getExperiencia()))
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexperiencia.getExperiencia(), dtoexperiencia.getEmpresa(), dtoexperiencia.getTareas(), dtoexperiencia.getPeriodo(), dtoexperiencia.getImg());
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia añadida"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexperiencia){
        //Validamos si existe el id
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombres de experiencia
        if(sExperiencia.existsByExperiencia(dtoexperiencia.getExperiencia()) && sExperiencia.getByExperiencia(dtoexperiencia.getExperiencia()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacío
        if(StringUtils.isBlank(dtoexperiencia.getExperiencia()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setExperiencia(dtoexperiencia.getExperiencia());
        experiencia.setEmpresa(dtoexperiencia.getEmpresa());
        experiencia.setTareas(dtoexperiencia.getTareas());
        experiencia.setPeriodo(dtoexperiencia.getPeriodo());
        experiencia.setImg(dtoexperiencia.getImg());
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
         //Validamos si existe el id
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        sExperiencia.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    
}

package com.portfolio.mjos.Controller;

import com.portfolio.mjos.DTO.dtoCursos;
import com.portfolio.mjos.Entity.Cursos;
import com.portfolio.mjos.Security.Controller.Mensaje;
import com.portfolio.mjos.Service.SCursos;
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
@RequestMapping("/cursos")
@CrossOrigin (origins = {"https://mgbfrontend.web.app", "http://localhost:4200"})
public class CCursos {
    
    @Autowired
    SCursos sCursos;

    @GetMapping("/lista")
    public ResponseEntity<List<Cursos>> list() {
        List<Cursos> list = sCursos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Cursos> getById(@PathVariable("id") int id) {
        if (!sCursos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        Cursos cursos = sCursos.getOne(id).get();
        return new ResponseEntity(cursos, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoCursos dtocursos) {
        if (StringUtils.isBlank(dtocursos.getCurso())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sCursos.existsByCurso(dtocursos.getCurso())) {
            return new ResponseEntity(new Mensaje("Ese curso ya existe"), HttpStatus.BAD_REQUEST);
        }

        Cursos cursos = new Cursos(
                dtocursos.getCurso(), dtocursos.getInstitucionCurso(), dtocursos.getFechaFinalizacion(), dtocursos.getEstado(), dtocursos.getImg());
        sCursos.save(cursos);

        return new ResponseEntity(new Mensaje("Curso añadido"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoCursos dtocursos) {
        //Validamos si existe el id
        if (!sCursos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombres de experiencia
        if (sCursos.existsByCurso(dtocursos.getCurso()) && sCursos.getByCurso(dtocursos.getCurso()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese curso ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacío
        if (StringUtils.isBlank(dtocursos.getCurso())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Cursos cursos = sCursos.getOne(id).get();
        cursos.setCurso(dtocursos.getCurso());
        cursos.setInstitucionCurso(dtocursos.getInstitucionCurso());
        cursos.setFechaFinalizacion(dtocursos.getFechaFinalizacion());
        cursos.setEstado(dtocursos.getEstado());
        cursos.setImg(dtocursos.getImg());

        sCursos.save(cursos);
        return new ResponseEntity(new Mensaje("Curso actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el id
        if (!sCursos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        sCursos.delete(id);

        return new ResponseEntity(new Mensaje("Curso eliminado"), HttpStatus.OK);
    }

    
}

package com.portfolio.mjos.Controller;

import com.portfolio.mjos.DTO.dtoHabilidades;
import com.portfolio.mjos.Entity.Habilidades;
import com.portfolio.mjos.Security.Controller.Mensaje;
import com.portfolio.mjos.Service.SHabilidades;
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
@CrossOrigin(origins = {"https://mgbfrontend.web.app", "http://localhost:4200"})
@RequestMapping("/habilidades")
public class CHabilidades {

    @Autowired
    SHabilidades sHabilidades;

    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = sHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id) {
        if (!sHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        Habilidades habilidades = sHabilidades.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtohabilidades) {
        if (StringUtils.isBlank(dtohabilidades.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sHabilidades.existsByNombre(dtohabilidades.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        Habilidades habilidades = new Habilidades(
                dtohabilidades.getNombre(), dtohabilidades.getGrupo(), dtohabilidades.getCategoria(), dtohabilidades.getNivel(), dtohabilidades.getImg());
        sHabilidades.save(habilidades);

        return new ResponseEntity(new Mensaje("Habilidad añadida"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidades dtohabilidades) {
        //Validamos si existe el id
        if (!sHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombres de experiencia
        if (sHabilidades.existsByNombre(dtohabilidades.getNombre()) && sHabilidades.getByNombre(dtohabilidades.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacío
        if (StringUtils.isBlank(dtohabilidades.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidades habilidades = sHabilidades.getOne(id).get();
        habilidades.setNombre(dtohabilidades.getNombre());
        habilidades.setGrupo(dtohabilidades.getGrupo());
        habilidades.setCategoria(dtohabilidades.getCategoria());
        habilidades.setNivel(dtohabilidades.getNivel());
        habilidades.setImg(dtohabilidades.getImg());

        sHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el id
        if (!sHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        sHabilidades.delete(id);

        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

}

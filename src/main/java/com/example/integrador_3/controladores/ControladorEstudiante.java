package com.example.integrador_3.controladores;

import com.example.integrador_3.models.Estudiante;
import com.example.integrador_3.servicios.ServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiante {
    @Autowired
    private ServicioEstudiante estudianteServicio;


    @GetMapping("genero/{genero}")
    public ResponseEntity<?> getEstudiantesPorGenero(@PathVariable String genero) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.getEstudiantesPorGenero(genero));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("")
    public ResponseEntity<?> getEstudiantesOrdenadosPorApellido(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.getEstudiantesOrdenadosPorApellido());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getEstudianteNumLibreta(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.getEstudiantePorNumLibreta(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el objeto buscado" +
                    ".\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo editar, revise los campos e intente nuevamente.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(estudianteServicio.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. no se pudo eliminar intente nuevamente.\"}");
        }
    }
}

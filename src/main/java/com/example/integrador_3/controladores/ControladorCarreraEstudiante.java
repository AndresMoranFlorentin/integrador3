package com.example.integrador_3.controladores;

import com.example.integrador_3.models.Carrera_Estudiante;
import com.example.integrador_3.repositories.CarreraEstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrera_estudiantes")
public class ControladorCarreraEstudiante {
    @Autowired
    private CarreraEstudianteRepo ceRepo;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Carrera_Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ceRepo.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }
}

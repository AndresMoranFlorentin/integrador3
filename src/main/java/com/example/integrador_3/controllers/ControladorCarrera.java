package com.example.integrador_3.controllers;

import com.example.integrador_3.models.Carrera;
import com.example.integrador_3.repositories.CarreraRepo;
import com.example.integrador_3.services.ServicioCarrera;
import com.example.integrador_3.services.ServicioEstudiante;
import com.example.integrador_3.views.CarreraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
public class ControladorCarrera {
    @Autowired
    private ServicioCarrera servicioCarrera;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Carrera entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicioCarrera.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }
    @GetMapping("/inscriptos")
    public ResponseEntity<?> getCarrerasConInscriptos() throws Exception {
         try{
            return ResponseEntity.status(HttpStatus.OK).body(servicioCarrera.getCarrerasConInscriptos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Error. No se encuentra la lista de inscriptos de la carrera}");
        }
    }

}

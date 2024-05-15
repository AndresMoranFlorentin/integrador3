package com.example.integrador_3.controllers;

import com.example.integrador_3.models.CarreraEstudiantePorDni;
import com.example.integrador_3.models.Carrera_Estudiante;
import com.example.integrador_3.repositories.CarreraEstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/carrera_estudiantes")
public class ControladorCarreraEstudiante {
    @Autowired
    private CarreraEstudianteRepo ceRepo;
    @GetMapping("/{id_carrera}/{dni}")
    public ResponseEntity<?> getCarrerasEstudiantePorId(@PathVariable Long id_carrera,@PathVariable Long dni) throws Exception {
        System.out.println("idCarrera: "+id_carrera+", dni: "+dni);
        CarreraEstudiantePorDni id=new CarreraEstudiantePorDni(id_carrera,dni);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ceRepo.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Error. No se encuentra la carrera buscada}");
        }
    }
    @PostMapping("matricular/{id_registro}/{id_carrera}/{dni}")
    public ResponseEntity<?> matricularEstudiante(@PathVariable Long id_registro,@PathVariable Long id_carrera,@PathVariable Long dni) throws Exception {
        System.out.println("id_carrera: "+id_carrera+", dni: "+dni);
        CarreraEstudiantePorDni id=new CarreraEstudiantePorDni(id_carrera,dni);
        int fechaIns= LocalDate.now().getYear();
        Carrera_Estudiante nuevo=new Carrera_Estudiante(id_registro,id_carrera,dni,fechaIns,0,0);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ceRepo.save(nuevo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Error. No se encuentra la carrera buscada}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Carrera_Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ceRepo.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }
}

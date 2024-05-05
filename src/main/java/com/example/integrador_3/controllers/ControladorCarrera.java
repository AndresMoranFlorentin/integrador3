package com.example.integrador_3.controllers;

import com.example.integrador_3.models.Carrera;
import com.example.integrador_3.repositories.CarreraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrera")
public class ControladorCarrera {
    @Autowired
    private CarreraRepo carreraRepo;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Carrera entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carreraRepo.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }
//    @GetMapping("")
//    public List<CarreraDto> getCarrerasConInscriptos() throws Exception {
//        var resultado = carreraRepo.getCarrerasConInscriptos();
//        try {
//            return resultado.stream().map(carrera -> new CarreraDto(carrera.getId_carrera(), carrera.getNombre(), carrera.getDuracion(), carrera.getCant_inscriptos())).collect(Collectors.toList());
//        }
//        catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
}

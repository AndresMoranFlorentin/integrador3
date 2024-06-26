package com.example.integrador_3.controllers;

import com.example.integrador_3.models.Carrera;
import com.example.integrador_3.services.ServicioCarrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping("/{id_carrera}")
    public ResponseEntity<?> getCarrerasPorId(@PathVariable Long id_carrera) throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicioCarrera.getCarreraPorId(id_carrera));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Error. No se encuentra la carrera buscada}");
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
    @GetMapping("/reporteCarrerasPorAño")
    public ResponseEntity<?> getReporteDeCarrerasPorAnio() throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioCarrera.getReporteDeLasCarrerasCronologico());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Error. No se pudo generar el reporte de las carreras por año cronologico}");

        }
    }
}

package com.example.integrador_3.services;

import com.example.integrador_3.models.Estudiante;
import com.example.integrador_3.repositories.EstudianteRepo;
import com.example.integrador_3.views.EstudianteDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("ServicioEstudiante")
public class ServicioEstudiante {
    @Autowired
    private EstudianteRepo estuRepo;

    @Transactional
    public Estudiante getEstudiantePorNumLibreta(Long lib) throws Exception {

        var resultado = estuRepo.getEstudiantePorNumLibreta(lib);
        try {
            return resultado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDto> getEstudiantesPorGenero(String genero) throws Exception {
        System.out.println("El genero que llega es:----------->" + genero);
        var resultado = estuRepo.findByGenero(genero);
        try {
            return resultado.stream().map(estudiante -> new EstudianteDto(estudiante.getDni(), estudiante.getLibretaUniversitaria(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getGenero(), estudiante.getEdad(), estudiante.getCiudad())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDto> getEstudiantesOrdenadosPorApellido() throws Exception {
        var resultado = estuRepo.getEstudiantesPorOrdenDelApellido();
        try {
            return resultado.stream().map(estudiante -> new EstudianteDto(estudiante.getDni(), estudiante.getLibretaUniversitaria(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getGenero(), estudiante.getEdad(), estudiante.getCiudad())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDto> getEstudiantesPorCarreraYCiudad(Long id_carrera, String ciudad) throws Exception {
        System.out.println("el id carrera es: " + id_carrera + ", y la ciudad es: " + ciudad);
        var resultado = estuRepo.getEstudiantesPorCarreraYCiudad(id_carrera, ciudad);
        System.out.println("el resultado es: " + resultado);
        try {
            return resultado.stream().map(estudiante -> new EstudianteDto(estudiante.getDni(), estudiante.getLibretaUniversitaria(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getGenero(), estudiante.getEdad(), estudiante.getCiudad())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Estudiante save(Estudiante entity) throws Exception {
        try {
            return estuRepo.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Estudiante update(Long id, Estudiante entity) throws Exception {
        try {
            Optional<Estudiante> entityOpcional = Optional.ofNullable(estuRepo.getEstudiantePorNumLibreta(id));
            Estudiante estudiante = entityOpcional.get();
            estudiante = (Estudiante) estuRepo.save(entity);
            return estudiante;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (estuRepo.existsById(id)) {
                estuRepo.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
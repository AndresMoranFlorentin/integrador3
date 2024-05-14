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
            return resultado.stream().map(estudiante -> new EstudianteDto(estudiante.getDni(), estudiante.getLibreta_universitaria(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getGenero(), estudiante.getEdad(), estudiante.getCiudad())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Estudiante> getEstudiantesOrdenadosPorApellido() throws Exception {
        var resultado = estuRepo.getEstudiantesPorOrdenDelApellido();
        try {
            return resultado.stream().map(estudiante -> new Estudiante(estudiante.getDni(), estudiante.getLibreta_universitaria(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getGenero(), estudiante.getEdad(), estudiante.getCiudad())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Estudiante> getEstudiantesPorCarreraYCiudad(Long id_carrera, String ciudad) throws Exception {
         var resultados = estuRepo.getEstudiantesPorCarreraYCiudad(id_carrera, ciudad);
         try {
            return  resultados;
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
            Optional<Estudiante> entityOpcional = estuRepo.findById(id);
            Estudiante estu = entityOpcional.get();
            estu = estuRepo.save(entity);
            return estu;
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
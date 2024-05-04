package com.example.integrador_3.servicios;

import com.example.integrador_3.models.Estudiante;
import com.example.integrador_3.repositories.EstudianteRepo;
import com.example.integrador_3.vistas.EstudianteDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return resultado;//.stream().map(estudiante -> new EstudianteDto().collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDto> getEstudiantesPorGenero(String genero) throws Exception {
        var resultado = estuRepo.getEstudiantePorGenero(genero);
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
    public List<EstudianteDto> getEstudiantesPorCarreraYCiudad(String ciudad, Long id_carrera) throws Exception {
        var resultado = estuRepo.getEstudiantesPorCarreraYCiudad(id_carrera, ciudad);
        try {
            return resultado.stream().map(estudiante -> new EstudianteDto(estudiante.getDni(), estudiante.getLibretaUniversitaria(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getGenero(), estudiante.getEdad(), estudiante.getCiudad())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Estudiante save(Estudiante entity) throws Exception {
        try{
            return (Estudiante) estuRepo.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Estudiante update(Long id, Estudiante entity) throws Exception {
        try{
            Optional<Estudiante> entityOpcional = Optional.ofNullable(estuRepo.getEstudiantePorNumLibreta(id));
            Estudiante estudiante = entityOpcional.get();
            estudiante = (Estudiante) estuRepo.save(entity);
            return estudiante;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(estuRepo.existsById(id)){
                estuRepo.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
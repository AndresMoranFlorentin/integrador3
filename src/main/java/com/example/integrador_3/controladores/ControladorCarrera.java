package com.example.integrador_3.controladores;

import com.example.integrador_3.models.Carrera;
import com.example.integrador_3.repositories.CarreraRepo;
import com.example.integrador_3.vistas.CarreraDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("ServicioCarrera")
public class ControladorCarrera {
    @Autowired
    private CarreraRepo carreraRepo;

    @Transactional
    public Carrera getCarreraByID(Long id_carrera) throws Exception {
        var resultado = carreraRepo.getCarreraByID(id_carrera);
        try {
            return resultado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<CarreraDto> getCarrerasConInscriptos() throws Exception {
        var resultado = carreraRepo.getCarrerasConInscriptos();
        try {
            return resultado.stream().map(carrera -> new CarreraDto(carrera.getId_carrera(), carrera.getNombre(), carrera.getDuracion(), carrera.getCant_inscriptos())).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

package com.example.integrador_3.services;

import com.example.integrador_3.models.Carrera;
import com.example.integrador_3.models.Estudiante;
import com.example.integrador_3.repositories.CarreraRepo;
import com.example.integrador_3.views.CarreraDto;
import com.example.integrador_3.views.CarreraDtoInscripto;
import com.example.integrador_3.views.EstudianteDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("ServicioCarrera")
public class ServicioCarrera{

    @Autowired
    private CarreraRepo carreraRepo;

    @Transactional
    public Carrera getCarreraByID(Long id)throws Exception{

        var resultado = carreraRepo.getCarreraByID(id);
        try{
            return resultado;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Carrera save(Carrera entity) throws Exception {
        try{
            return (Carrera)  carreraRepo.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
//    @Transactional
//    public List<CarreraDtoInscripto> getCarrerasConInscriptos()throws Exception{
//        var resultado =carreraRepo.getCarrerasConInscriptos();
//        try{
//            return resultado.stream().map(carrera -> new CarreraDtoInscripto(carrera.getId_carrera(),carrera.getNombre(),carrera.getDuracion(),carrera.getCant_inscriptos())).collect(Collectors.toList());
//        }catch (Exception e){
//            throw new Exception(e.getMessage());
//        }
//    }
@Transactional
public List<CarreraDto> getCarrerasConInscriptos()throws Exception{
    var resultado =carreraRepo.getCarrerasConInscriptos();
    try{
        return  resultado.stream().map(carrera -> new CarreraDto(carrera.getId_carrera(),carrera.getNombre(),carrera.getDuracion())).collect(Collectors.toList());
    }catch (Exception e){
        throw new Exception(e.getMessage());
    }
}
}

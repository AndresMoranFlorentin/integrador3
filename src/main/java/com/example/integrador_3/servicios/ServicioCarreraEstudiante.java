package com.example.integrador_3.servicios;

import com.example.integrador_3.models.Carrera_Estudiante;
import com.example.integrador_3.repositories.CarreraEstudianteRepo;
import jakarta.transaction.Transactional;

public class ServicioCarreraEstudiante {

    private CarreraEstudianteRepo ceRepo;
    @Transactional
    public Carrera_Estudiante save(Carrera_Estudiante entity) throws Exception {
        try{
            return (Carrera_Estudiante) ceRepo.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

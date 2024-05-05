package com.example.integrador_3.servicios;

import com.example.integrador_3.models.Carrera;
import com.example.integrador_3.repositories.CarreraRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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

}

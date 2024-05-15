package com.example.integrador_3.services;

import com.example.integrador_3.models.Carrera;
import com.example.integrador_3.repositories.CarreraRepo;
import com.example.integrador_3.views.CarreraDtoInscriptos;
import com.example.integrador_3.views.ReporteTdo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ServicioCarrera")
public class ServicioCarrera {

    @Autowired
    private CarreraRepo carreraRepo;

    @Transactional
    public Carrera save(Carrera entity) throws Exception {
        try {
            return (Carrera) carreraRepo.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<CarreraDtoInscriptos> getCarrerasConInscriptos() throws Exception {
        List<Object[]> resultados = carreraRepo.getCarrerasConInscriptos();
        List<CarreraDtoInscriptos> lista = new ArrayList<>();
        for (Object[] resultado : resultados) {
            Long idCarrera = (Long) resultado[0];
            String nombre = (String) resultado[1];
            int duracion = (int) resultado[2];
            Long cantInscriptos =(Long) resultado[3]; // El resultado del conteo es de tipo long
            Integer cI=Integer.parseInt(String.valueOf(cantInscriptos));
            CarreraDtoInscriptos nuevo = new CarreraDtoInscriptos(idCarrera, nombre, duracion, cI);
            lista.add(nuevo);
        }
         try {
            return lista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<ReporteTdo> getReporteDeLasCarrerasCronologico() throws Exception {
        List<Object[]> resultados = carreraRepo.getReporteCarreras();
        List<ReporteTdo> lista = new ArrayList<>();
        for (Object[] resultado : resultados) {
            String nombre = (String) resultado[0];
            int anio = (int) resultado[1];
            Long cantInscriptos =(Long) resultado[2]; // El resultado del conteo es de tipo long
            Long cantEgresados=(Long)resultado[3];
            ReporteTdo nuevo = new ReporteTdo(nombre, anio, cantInscriptos,cantEgresados);
            lista.add(nuevo);
        }
        try {
            return lista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
     @Transactional
    public Optional<Carrera> getCarreraPorId(Long id) throws Exception {
        var resultado = carreraRepo.findById(id);
        try {
            return resultado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}

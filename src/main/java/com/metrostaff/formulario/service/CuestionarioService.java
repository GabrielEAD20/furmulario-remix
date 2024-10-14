package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.Cuestionario;
import com.metrostaff.formulario.repository.CuestionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CuestionarioService {

    private final CuestionarioRepository cuestionarioRepository;

    public CuestionarioService(CuestionarioRepository cuestionarioRepository) {
        this.cuestionarioRepository = cuestionarioRepository;
    }

    public List<Cuestionario> getAllCuestionarios() {
        return cuestionarioRepository.findAll();
    }

    public Cuestionario getCuestionarioById(Integer id) {
        return cuestionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuestionario not found with id " + id));
    }

    public Cuestionario createCuestionario(Date fecha, Integer idEtapa, String nombreCuestionario ) {
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setNombreCuestionario(nombreCuestionario);
        cuestionario.setFecha(fecha);
        cuestionario.setIdEtapa(idEtapa);
        return cuestionarioRepository.save(cuestionario);
    }

    public Cuestionario updateCuestionario(Integer id, Date fecha, Integer idEtapa) {
        Cuestionario cuestionario = cuestionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuestionario not found with id " + id));
        cuestionario.setFecha(fecha);
        cuestionario.setIdEtapa(idEtapa);
        return cuestionarioRepository.save(cuestionario);
    }

    public void deleteCuestionario(Integer id) {
        if (!cuestionarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Cuestionario not found with id " + id);
        }
        cuestionarioRepository.deleteById(id);
    }
}

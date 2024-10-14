package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.PreguntaCuestionario;
import com.metrostaff.formulario.repository.PreguntaCuestionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaCuestionarioService {

    private final PreguntaCuestionarioRepository preguntaCuestionarioRepository;

    public PreguntaCuestionarioService(PreguntaCuestionarioRepository preguntaCuestionarioRepository) {
        this.preguntaCuestionarioRepository = preguntaCuestionarioRepository;
    }

    public List<PreguntaCuestionario> getAllPreguntasCuestionario() {
        return preguntaCuestionarioRepository.findAll();
    }


    // Obtener PreguntaCuestionario por idCuestionario y nroPregunta
    public PreguntaCuestionario getPreguntaCuestionarioByIdCuestionarioAndByNroPregunta(Integer idCuestionario, Integer numeroDePregunta) {
        return preguntaCuestionarioRepository.findByIdCuestionarioAndNroPregunta(idCuestionario, numeroDePregunta)
                .orElseThrow(() -> new EntityNotFoundException("PreguntaCuestionario not found with idCuestionario " + idCuestionario + " and nroPregunta " + numeroDePregunta));
    }

    public PreguntaCuestionario createPreguntaCuestionario(Integer idCuestionario, Integer idPregunta, Integer idOpcionPreg, String observaciones) {
        PreguntaCuestionario preguntaCuestionario = new PreguntaCuestionario();
        preguntaCuestionario.setIdCuestionario(idCuestionario);
        preguntaCuestionario.setIdPregunta(idPregunta);
        preguntaCuestionario.setIdOpcionPreg(idOpcionPreg);
        preguntaCuestionario.setObservaciones(observaciones);
        return preguntaCuestionarioRepository.save(preguntaCuestionario);
    }

    public PreguntaCuestionario updatePreguntaCuestionario(Integer id, Integer idCuestionario, Integer idPregunta, Integer idOpcionPreg, String observaciones) {
        PreguntaCuestionario preguntaCuestionario = preguntaCuestionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PreguntaCuestionario not found with id " + id));
        preguntaCuestionario.setIdCuestionario(idCuestionario);
        preguntaCuestionario.setIdPregunta(idPregunta);
        preguntaCuestionario.setIdOpcionPreg(idOpcionPreg);
        preguntaCuestionario.setObservaciones(observaciones);
        return preguntaCuestionarioRepository.save(preguntaCuestionario);
    }

    public void deletePreguntaCuestionario(Integer id) {
        if (!preguntaCuestionarioRepository.existsById(id)) {
            throw new EntityNotFoundException("PreguntaCuestionario not found with id " + id);
        }
        preguntaCuestionarioRepository.deleteById(id);
    }
}

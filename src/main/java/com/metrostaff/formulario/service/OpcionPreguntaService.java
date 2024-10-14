package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.OpcionPregunta;
import com.metrostaff.formulario.repository.OpcionPreguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcionPreguntaService {

    private final OpcionPreguntaRepository opcionPreguntaRepository;

    public OpcionPreguntaService(OpcionPreguntaRepository opcionPreguntaRepository) {
        this.opcionPreguntaRepository = opcionPreguntaRepository;
    }

    public List<OpcionPregunta> getAllOpcionesPregunta() {
        return opcionPreguntaRepository.findAll();
    }
    public List<OpcionPregunta> getAllOpcionesByPreguntaId(Integer idPregunta) {
        return   opcionPreguntaRepository.findByIdPregunta(idPregunta);

    }
    public OpcionPregunta getOpcionPreguntaById(Integer id) {
        return opcionPreguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OpcionPregunta not found with id " + id));
    }

    public OpcionPregunta createOpcionPregunta(String descripcion, String descripcionMostrar, Integer idPregunta) {
        OpcionPregunta opcionPregunta = new OpcionPregunta();
        opcionPregunta.setDescripcion(descripcion);
        opcionPregunta.setDescripcionMostrar(descripcionMostrar);
        opcionPregunta.setIdPregunta(idPregunta);
        return opcionPreguntaRepository.save(opcionPregunta);
    }

    public OpcionPregunta updateOpcionPregunta(Integer id, String descripcion, String descripcionMostrar, Integer idPregunta) {
        OpcionPregunta opcionPregunta = opcionPreguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OpcionPregunta not found with id " + id));
        opcionPregunta.setDescripcion(descripcion);
        opcionPregunta.setDescripcionMostrar(descripcionMostrar);
        opcionPregunta.setIdPregunta(idPregunta);
        return opcionPreguntaRepository.save(opcionPregunta);
    }

    public void deleteOpcionPregunta(Integer id) {
        if (!opcionPreguntaRepository.existsById(id)) {
            throw new EntityNotFoundException("OpcionPregunta not found with id " + id);
        }
        opcionPreguntaRepository.deleteById(id);
    }
}

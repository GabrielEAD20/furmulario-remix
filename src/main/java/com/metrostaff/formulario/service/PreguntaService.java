package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.Pregunta;
import com.metrostaff.formulario.models.PreguntaCuestionario;
import com.metrostaff.formulario.repository.PreguntaRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public PreguntaService(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    public List<Pregunta> getAllPreguntas() {
        return preguntaRepository.findAll();
    }

    public Pregunta getById(Integer id) {
        return preguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta not found with id " + id));
    }

    public Pregunta createPregunta(String descripcion, String descripcionMostrar, int nroOrden, boolean tieneOpciones, String textoRespuesta) {
        Pregunta pregunta = new Pregunta();
        pregunta.setDescripcion(descripcion);
        pregunta.setDescripcionMostrar(descripcionMostrar);
        pregunta.setNroOrden(nroOrden);
        pregunta.setTieneOpciones(tieneOpciones);
        pregunta.setTextoRespuesta(textoRespuesta);
        return preguntaRepository.save(pregunta);
    }

    public Pregunta updatePregunta(Integer id, String descripcion, String descripcionMostrar, int nroOrden, boolean tieneOpciones, String textoRespuesta) {
        Pregunta pregunta = preguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta not found with id " + id));
        pregunta.setDescripcion(descripcion);
        pregunta.setDescripcionMostrar(descripcionMostrar);
        pregunta.setNroOrden(nroOrden);
        pregunta.setTieneOpciones(tieneOpciones);
        pregunta.setTextoRespuesta(textoRespuesta);
        return preguntaRepository.save(pregunta);
    }

    public void deletePregunta(Integer id) {
        if (!preguntaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pregunta not found with id " + id);
        }
        preguntaRepository.deleteById(id);
    }
}

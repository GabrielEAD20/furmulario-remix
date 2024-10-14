package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.Pregunta;
import com.metrostaff.formulario.models.SecuenciaPregunta;
import com.metrostaff.formulario.repository.PreguntaRepository;
import com.metrostaff.formulario.repository.SecuenciaPreguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecuenciaPreguntaService {

    private final SecuenciaPreguntaRepository secuenciaPreguntaRepository;

    private final PreguntaRepository preguntaRepository;

    public SecuenciaPreguntaService(SecuenciaPreguntaRepository secuenciaPreguntaRepository, PreguntaRepository preguntaRepository) {
        this.secuenciaPreguntaRepository = secuenciaPreguntaRepository;
        this.preguntaRepository = preguntaRepository;
    }

    public List<SecuenciaPregunta> getAllSecuenciasPregunta() {
        return secuenciaPreguntaRepository.findAll();
    }

    public SecuenciaPregunta getSecuenciaPreguntaById(Integer id) {
        return secuenciaPreguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SecuenciaPregunta not found with id " + id));
    }

    public SecuenciaPregunta createSecuenciaPregunta(Integer idOpcionPregunta, Integer idPreguntaSiguiente) {
        SecuenciaPregunta secuenciaPregunta = new SecuenciaPregunta();
        secuenciaPregunta.setIdOpcionPregunta(idOpcionPregunta);
        secuenciaPregunta.setIdPreguntaSiguiente(idPreguntaSiguiente);
        return secuenciaPreguntaRepository.save(secuenciaPregunta);
    }

    public SecuenciaPregunta updateSecuenciaPregunta(Integer id, Integer idOpcionPregunta, Integer idPreguntaSiguiente) {
        SecuenciaPregunta secuenciaPregunta = secuenciaPreguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SecuenciaPregunta not found with id " + id));
        secuenciaPregunta.setIdOpcionPregunta(idOpcionPregunta);
        secuenciaPregunta.setIdPreguntaSiguiente(idPreguntaSiguiente);
        return secuenciaPreguntaRepository.save(secuenciaPregunta);
    }

    public void deleteSecuenciaPregunta(Integer id) {
        if (!secuenciaPreguntaRepository.existsById(id)) {
            throw new EntityNotFoundException("SecuenciaPregunta not found with id " + id);
        }
        secuenciaPreguntaRepository.deleteById(id);
    }

    public Pregunta getNextPregunta(Integer questionId, Integer selectedOptionId) {
        // Lógica para encontrar la siguiente pregunta basada en la opción seleccionada.
        SecuenciaPregunta secuencia = secuenciaPreguntaRepository.findByIdOpcionPregunta(selectedOptionId)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la secuencia para la opción seleccionada"));
        return preguntaRepository.findById(secuencia.getIdPreguntaSiguiente())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la siguiente pregunta"));
    }
}

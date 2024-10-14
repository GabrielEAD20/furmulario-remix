package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.RespuestaPregunta;
import com.metrostaff.formulario.repository.RespuestaPreguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RespuestaPreguntaService {

    @Autowired
    private RespuestaPreguntaRepository respuestaPreguntaRepository;

    // Método para obtener una respuesta por ID
    public RespuestaPregunta obtenerRespuestaPorId(int id) {
        return respuestaPreguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Respuesta no encontrada con el ID: " + id));
    }

    // Método para crear una nueva respuesta pasando parámetros individuales
    public RespuestaPregunta crearRespuesta(Integer idFormulario,Integer idPregunta, String idTipoPregunta, String valorRespuesta) {
        RespuestaPregunta nuevaRespuesta = new RespuestaPregunta();
        nuevaRespuesta.setIdFormulario(idFormulario);
        nuevaRespuesta.setIdPregunta(idPregunta);
        nuevaRespuesta.setIdTypoPregunta(idTipoPregunta);
        nuevaRespuesta.setValorRespuesta(valorRespuesta);

        return respuestaPreguntaRepository.save(nuevaRespuesta);
    }

    // Método para actualizar una respuesta existente pasando parámetros individuales
    public RespuestaPregunta actualizarRespuesta(Integer idFormulario, int id, Integer idPregunta, String idTipoPregunta, String valorRespuesta) {
        RespuestaPregunta respuestaExistente = respuestaPreguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Respuesta no encontrada con el ID: " + id));

        // Actualizar los campos individualmente
        respuestaExistente.setIdFormulario(idFormulario);
        respuestaExistente.setIdPregunta(idPregunta);
        respuestaExistente.setIdTypoPregunta(idTipoPregunta);
        respuestaExistente.setValorRespuesta(valorRespuesta);

        return respuestaPreguntaRepository.save(respuestaExistente);
    }

    // Método para eliminar una respuesta por ID
    public void eliminarRespuesta(int id) {
        RespuestaPregunta respuestaExistente = respuestaPreguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Respuesta no encontrada con el ID: " + id));

        respuestaPreguntaRepository.delete(respuestaExistente);
    }

    // Método para obtener todas las respuestas
    public List<RespuestaPregunta> obtenerTodasLasRespuestas() {
        return respuestaPreguntaRepository.findAll();
    }
}


package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.Postulante;
import com.metrostaff.formulario.models.PostulantePostulacion;
import com.metrostaff.formulario.repository.PostulantePostulacionRepository;
import com.metrostaff.formulario.repository.PostulanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostulantePostulacionService {

    private final PostulantePostulacionRepository postulantePostulacionRepository;

    private final PostulanteRepository postulanteRepository;

    public PostulantePostulacionService(PostulantePostulacionRepository postulantePostulacionRepository, PostulanteRepository postulanteRepository) {
        this.postulantePostulacionRepository = postulantePostulacionRepository;
        this.postulanteRepository = postulanteRepository;
    }

    public List<PostulantePostulacion> getAllPostulaciones() {
        return postulantePostulacionRepository.findAll();
    }

    public PostulantePostulacion getPostulacionById(Integer id) {
        return postulantePostulacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PostulantePostulacion not found with id " + id));
    }

    public PostulantePostulacion createPostulacion(Integer idPostulante, Integer idEtapa, String observacion) {
        PostulantePostulacion postulantePostulacion = new PostulantePostulacion();
        Postulante postulante = postulanteRepository.findById(idPostulante)
                .orElseThrow(() -> new EntityNotFoundException("Postulante not found with id " + idPostulante));
        postulantePostulacion.setPostulante(postulante);
        postulantePostulacion.setIdEtapa(idEtapa);
        postulantePostulacion.setObservacion(observacion);
        return postulantePostulacionRepository.save(postulantePostulacion);
    }

    public PostulantePostulacion updatePostulacion(Integer id, Integer idPostulante, Integer idEtapa, String observacion) {
        PostulantePostulacion postulantePostulacion = postulantePostulacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PostulantePostulacion not found with id " + id));
        Postulante postulante = postulanteRepository.findById(idPostulante)
                .orElseThrow(() -> new EntityNotFoundException("Postulante not found with id " + idPostulante));
        postulantePostulacion.setPostulante(postulante);
        postulantePostulacion.setIdEtapa(idEtapa);
        postulantePostulacion.setObservacion(observacion);
        return postulantePostulacionRepository.save(postulantePostulacion);
    }

    public void deletePostulacion(Integer id) {
        if (!postulantePostulacionRepository.existsById(id)) {
            throw new EntityNotFoundException("PostulantePostulacion not found with id " + id);
        }
        postulantePostulacionRepository.deleteById(id);
    }
}

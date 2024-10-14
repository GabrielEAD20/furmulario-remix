package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.Postulante;
import com.metrostaff.formulario.repository.PostulanteRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PostulanteService {

    private final PostulanteRepository postulanteRepository;

    public PostulanteService(PostulanteRepository postulanteRepository) {
        this.postulanteRepository = postulanteRepository;
    }

    public List<Postulante> getAllPostulantes() {
        return postulanteRepository.findAll();
    }

    public Postulante getPostulanteById(Integer id) {
        return postulanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Postulante not found with id " + id));
    }

    public Postulante createPostulante(String nombre, String apellidos) {
        Postulante postulante = new Postulante();
        postulante.setNombre(nombre);
        postulante.setApellidos(apellidos);
        return postulanteRepository.save(postulante);
    }

    public Postulante updatePostulante(Integer id, String nombre, String apellidos) {
        Postulante postulante = postulanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Postulante not found with id " + id));
        postulante.setNombre(nombre);
        postulante.setApellidos(apellidos);
        return postulanteRepository.save(postulante);
    }

    public void deletePostulante(Integer id) {
        if (!postulanteRepository.existsById(id)) {
            throw new EntityNotFoundException("Postulante not found with id " + id);
        }
        postulanteRepository.deleteById(id);
    }
}
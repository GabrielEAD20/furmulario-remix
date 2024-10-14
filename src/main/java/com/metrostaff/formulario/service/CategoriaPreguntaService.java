package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.CategoriaPregunta;
import com.metrostaff.formulario.repository.CategoriaPreguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaPreguntaService {

    private final CategoriaPreguntaRepository categoriaPreguntaRepository;

    public CategoriaPreguntaService(CategoriaPreguntaRepository categoriaPreguntaRepository) {
        this.categoriaPreguntaRepository = categoriaPreguntaRepository;
    }

    public List<CategoriaPregunta> getAllCategorias() {
        return categoriaPreguntaRepository.findAll();
    }

    public CategoriaPregunta getCategoriaById(Integer id) {
        return categoriaPreguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria not found with id " + id));
    }

    public CategoriaPregunta createCategoriaPregunta(String nombre, String descripcionMostrar, Integer idEtapaPostulacion) {
        CategoriaPregunta categoriaPregunta = new CategoriaPregunta();
        categoriaPregunta.setNombre(nombre);
        categoriaPregunta.setDescripcionMostrar(descripcionMostrar);
        categoriaPregunta.setIdEtapaPostulacion(idEtapaPostulacion);
        return categoriaPreguntaRepository.save(categoriaPregunta);
    }

    public CategoriaPregunta updateCategoriaPregunta(Integer id, String nombre, String descripcionMostrar, Integer idEtapaPostulacion) {
        CategoriaPregunta categoriaPregunta = categoriaPreguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria not found with id " + id));
        categoriaPregunta.setNombre(nombre);
        categoriaPregunta.setDescripcionMostrar(descripcionMostrar);
        categoriaPregunta.setIdEtapaPostulacion(idEtapaPostulacion);
        return categoriaPreguntaRepository.save(categoriaPregunta);
    }

    public void deleteCategoriaPregunta(Integer id) {
        if (!categoriaPreguntaRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoria not found with id " + id);
        }
        categoriaPreguntaRepository.deleteById(id);
    }
}

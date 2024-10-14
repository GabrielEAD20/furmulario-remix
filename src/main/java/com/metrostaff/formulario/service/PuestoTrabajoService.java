package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.PuestoTrabajo;
import com.metrostaff.formulario.repository.PuestoTrabajoRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PuestoTrabajoService {

    private final PuestoTrabajoRepository puestoTrabajoRepository;

    public PuestoTrabajoService(PuestoTrabajoRepository puestoTrabajoRepository) {
        this.puestoTrabajoRepository = puestoTrabajoRepository;
    }

    public List<PuestoTrabajo> getAllPuestosTrabajo() {
        return puestoTrabajoRepository.findAll();
    }

    public PuestoTrabajo getPuestoTrabajoById(Integer id) {
        return puestoTrabajoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PuestoTrabajo not found with id " + id));
    }

    public PuestoTrabajo createPuestoTrabajo(String nombre, int nroVacantes) {
        PuestoTrabajo puestoTrabajo = new PuestoTrabajo();
        puestoTrabajo.setNombre(nombre);
        puestoTrabajo.setNroVacantes(nroVacantes);
        return puestoTrabajoRepository.save(puestoTrabajo);
    }

    public PuestoTrabajo updatePuestoTrabajo(Integer id, String nombre, int nroVacantes) {
        PuestoTrabajo puestoTrabajo = puestoTrabajoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PuestoTrabajo not found with id " + id));
        puestoTrabajo.setNombre(nombre);
        puestoTrabajo.setNroVacantes(nroVacantes);
        return puestoTrabajoRepository.save(puestoTrabajo);
    }

    public void deletePuestoTrabajo(Integer id) {
        if (!puestoTrabajoRepository.existsById(id)) {
            throw new EntityNotFoundException("PuestoTrabajo not found with id " + id);
        }
        puestoTrabajoRepository.deleteById(id);
    }
}

package com.metrostaff.formulario.service;

import com.metrostaff.formulario.models.EtapaPostulacion;
import com.metrostaff.formulario.repository.EtapaPostulacionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtapaPostulacionService {

    private final EtapaPostulacionRepository etapaPostulacionRepository;

    public EtapaPostulacionService(EtapaPostulacionRepository etapaPostulacionRepository) {
        this.etapaPostulacionRepository = etapaPostulacionRepository;
    }

    public List<EtapaPostulacion> getAllEtapas() {
        return etapaPostulacionRepository.findAll();
    }

    public EtapaPostulacion getEtapaById(Integer id) {
        return etapaPostulacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EtapaPostulacion not found with id " + id));
    }

    public EtapaPostulacion createEtapaPostulacion(Integer idPuestoTrabajo) {
        EtapaPostulacion etapaPostulacion = new EtapaPostulacion();
        etapaPostulacion.setIdPuestoTrabajo(idPuestoTrabajo);
        return etapaPostulacionRepository.save(etapaPostulacion);
    }

    public EtapaPostulacion updateEtapaPostulacion(Integer id, Integer idPuestoTrabajo) {
        EtapaPostulacion etapaPostulacion = etapaPostulacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EtapaPostulacion not found with id " + id));
        etapaPostulacion.setIdPuestoTrabajo(idPuestoTrabajo);
        return etapaPostulacionRepository.save(etapaPostulacion);
    }

    public void deleteEtapaPostulacion(Integer id) {
        if (!etapaPostulacionRepository.existsById(id)) {
            throw new EntityNotFoundException("EtapaPostulacion not found with id " + id);
        }
        etapaPostulacionRepository.deleteById(id);
    }
}

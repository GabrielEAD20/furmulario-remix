package com.metrostaff.formulario.repository;

import com.metrostaff.formulario.models.PreguntaCuestionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreguntaCuestionarioRepository extends JpaRepository<PreguntaCuestionario, Integer> {
    Optional<PreguntaCuestionario> findByIdCuestionarioAndNroPregunta(Integer idCuestionario, Integer nroPregunta);

}

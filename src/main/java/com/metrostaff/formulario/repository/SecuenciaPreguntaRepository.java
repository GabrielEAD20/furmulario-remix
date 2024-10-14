package com.metrostaff.formulario.repository;

import com.metrostaff.formulario.models.SecuenciaPregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecuenciaPreguntaRepository extends JpaRepository<SecuenciaPregunta, Integer> {
    Optional<SecuenciaPregunta> findByIdOpcionPregunta(Integer idOpcionPregunta);
}

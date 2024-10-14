package com.metrostaff.formulario.repository;

import com.metrostaff.formulario.models.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
}

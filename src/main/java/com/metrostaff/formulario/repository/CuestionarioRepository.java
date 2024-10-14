package com.metrostaff.formulario.repository;

import com.metrostaff.formulario.models.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuestionarioRepository extends JpaRepository<Cuestionario, Integer> {
}
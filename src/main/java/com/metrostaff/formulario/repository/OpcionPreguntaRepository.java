package com.metrostaff.formulario.repository;

import com.metrostaff.formulario.models.OpcionPregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpcionPreguntaRepository extends JpaRepository<OpcionPregunta, Integer> {
    List<OpcionPregunta> findByIdPregunta(Integer idPregunta);


}

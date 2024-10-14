package com.metrostaff.formulario.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaCuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_cuestionario")
    private int idCuestionario;

    @Column(name = "id_pregunta")
    private int idPregunta;

    private int nroPregunta;

    @Column(name = "id_opcion_preg")
    private int idOpcionPreg;

    private String observaciones;

    // Getters y Setters
}
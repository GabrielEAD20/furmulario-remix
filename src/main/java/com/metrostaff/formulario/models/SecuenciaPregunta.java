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
public class SecuenciaPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_opcion_pregunta")
    private int idOpcionPregunta;

    @Column(name = "id_pregunta_siguiente")
    private int idPreguntaSiguiente;


}
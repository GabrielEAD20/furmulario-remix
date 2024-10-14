package com.metrostaff.formulario.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RespuestaPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idFormulario;
    private Integer IdPregunta;

    private String IdTypoPregunta;

    private String valorRespuesta;

}

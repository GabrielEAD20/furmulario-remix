package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ValidarPreguntasContestadasDTO {

    @JsonProperty("answered_questions")
    private List<String> answeredQuestions;

    // Getters y Setters
}

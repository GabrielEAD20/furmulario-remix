package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ValidarPreguntasContestadasDTO {

    @JsonProperty("answered_questions")
    private List<String> answeredQuestions;

    // Getters y Setters
}

package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnviarRespuestaDTO {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("next_question_id")
    private String nextQuestionId;

    @JsonProperty("section_id")
    private String sectionId;

    // Getters y Setters
}

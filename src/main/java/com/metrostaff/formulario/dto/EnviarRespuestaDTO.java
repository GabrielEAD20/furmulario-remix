package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnviarRespuestaDTO {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("next_question_id")
    private String nextQuestionId;

    @JsonProperty("section_id")
    private String sectionId;

    // Getters y Setters
}

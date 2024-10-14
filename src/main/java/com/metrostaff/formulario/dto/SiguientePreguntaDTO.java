package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class SiguientePreguntaDTO {

    @JsonProperty("next_question_id")
    private Integer nextQuestionId;

    @JsonProperty("question_text")
    private String questionText;

    @JsonProperty("question_type")
    private String questionType;

    @JsonProperty("options")
    private List<OpcionDTO> options;

    @JsonProperty("respuesta_guardad_id")
    private List<Integer> respuestasId;

    // Getters y Setters

    @Getter
    @Setter
    public static class OpcionDTO {
        @JsonProperty("option_id")
        private Integer optionId;

        @JsonProperty("option_text")
        private String optionText;

        // Getters y Setters
    }
}

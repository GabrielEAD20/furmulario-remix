package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SiguientePreguntaDTO {

    @JsonProperty("next_question_id")
    private String nextQuestionId;

    @JsonProperty("question_text")
    private String questionText;

    @JsonProperty("question_type")
    private String questionType;

    @JsonProperty("options")
    private List<OpcionDTO> options;

    // Getters y Setters

    public static class OpcionDTO {
        @JsonProperty("option_id")
        private String optionId;

        @JsonProperty("option_text")
        private String optionText;

        // Getters y Setters
    }
}

package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProgresoFormularioDTO {

    @JsonProperty("completed_sections")
    private List<SeccionDTO> completedSections;

    @JsonProperty("answered_questions")
    private List<PreguntaDTO> answeredQuestions;

    @JsonProperty("remaining_sections")
    private List<SeccionDTO> remainingSections;

    // Getters y Setters

    public static class SeccionDTO {
        @JsonProperty("section_id")
        private String sectionId;

        @JsonProperty("section_name")
        private String sectionName;

        // Getters y Setters
    }

    public static class PreguntaDTO {
        @JsonProperty("question_id")
        private String questionId;

        @JsonProperty("question_text")
        private String questionText;

        // Getters y Setters
    }
}
